import treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class BuildTree2 {

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 返回值表示树的根节点
     *
     * int[] preorder：前序数组
     * int preBegin 前序数组区间左界，左闭, int preEnd 前序数组区间右界，右开
     *
     * int[] inorder：中序数组
     * int inBegin 中序数组区间左界, int inEnd 前序数组区间右界
     */
    public TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {

        if (preBegin >= preEnd || inBegin >= inEnd) return null;

        //获取中间节点在中序数组中的下标
        int rootIndex = map.get(preorder[preBegin]);

        //构造中节点
        TreeNode root = new TreeNode(inorder[rootIndex]);

        //右子树对应的右区间长度
        int lenOfRight = inEnd - rootIndex - 1;

        //左子树根
        root.left = buildTree(preorder, preBegin + 1, preEnd - lenOfRight, inorder, inBegin, rootIndex);
        //右子树根
        root.right = buildTree(preorder, preEnd - lenOfRight, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }

}
