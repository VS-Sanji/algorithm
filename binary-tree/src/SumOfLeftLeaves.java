import treenode.TreeNode;

/**
 * 给你一个二叉树根节点，返回其所有左叶子之和
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;

        //左子树收集到的左叶子之和
        int leftValue = sumOfLeftLeaves(root.left);    // 左
        //右子树收集到的左叶子之和
        int rightValue = sumOfLeftLeaves(root.right);  // 右

        int midValue = 0;
        //只有从父节点才能判断出左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        //往上级函数返回以当前节点为根节点的所有收集到的左叶子之和
        return midValue + leftValue + rightValue;  // 中
    }
}
