import treenode.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * 遇到在二叉搜索树上求什么最值，求差值之类的，都要思考一下二叉搜索树可是有序的，要利用好这一特点。
 */
public class GetMinimumDifference {

    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if(root == null) return;
        //左
        traversal(root.left);
        //中
        if(pre != null) {
            result = Math.min(result,root.val-pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }


}
