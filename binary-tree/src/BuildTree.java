import treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 */
public class BuildTree {


    /**
     * 思路：根据后序获取根节点，然后在中序中利用根节点划分左右区间
     *      中序的左区间和后序的左区间所包含的元素一定是相同的，但顺序可能不同
     *      获取左区间后，就知道左区间有多少元素，然后在后序数组中从左开始划分左区间，该子左区间的最后一个元素又作为子树的根节点
     *      右区间同理，依次递归往复，最终拼成一棵树
     *
     *      整个过程可以这么来看：
     *      一开始所给出的 后序遍历数组以及中序遍历数组，对应着整棵树，初入递归时其区间为 0 ~ length，然后在此次处理中确定出根节点
     *      之后调用自身，确定左子树的根，右子树的根
     *      那么此时的后序以及中序数组不变，只需要改动区间即可，对于左子树，区间从 0 ~ rootIndex（中序） / postBegin, postBegin + lenOfLeft（后序）
     *                                                对于右子树，区间从 rootIndex + 1, inEnd / postBegin + lenOfLeft, postEnd - 1
     *      依次往复，最终确定整棵树
     */

    /**
     * 第一步：如果数组大小为零的话，说明是空节点了。
     *
     * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
     *
     * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
     *
     * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
     *
     * 第五步：切割后序数组，切成后序左数组和后序右数组
     *
     * 第六步：递归处理左区间和右区间
     */

    //用map来记录中序数组中各个元素与下标的对应关系,同时定义在外面，方便递归函数中使用
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //对于整棵树，对应于整个区间0, inorder.length / 0, postorder.length
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    //递归函数
    //使用左闭右开区间，并在循环中坚持左闭右开原则
    public TreeNode buildTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {

        //终止条件,当区间不合法时，表明没有元素需要处理了，区间合法是 左 < 右，所以不合法就是 左 >= 右
        if (inBegin >= inEnd || postBegin >= postEnd) return null;

        //单层处理逻辑
        //首先获取中节点
        // 找到后序遍历的最后一个元素在中序遍历中的位置
        int rootIndex = map.get(postorder[postEnd - 1]);//postEnd - 1的原因是，左闭右开区间要包含到区间所有元素的话，右界 需要等于最右元素下标 + 1，所以取最后一个元素需要 -1
        //构造中间节点
        TreeNode root = new TreeNode(inorder[rootIndex]);

        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树长度，用来确定后序遍历中属于左子树的部分

        //左子树 inBegin, rootIndex左子树中的左区间 postBegin, postBegin + lenOfLeft左子树的右区间
        root.left = buildTree(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        //右子树
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }

}
