import treenode.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    //left指的是左半子树根节点
    //right指的是右半子树根节点
    public static boolean isSym(TreeNode left, TreeNode right) {
        // 首先排除空节点的情况
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {//除去空节点，再刨除数值不同的情况
            return false;
        }
        //上述执行完表示左右根是相同的，是否是对称的看其子节点是否对称

        //“后序遍历”（不是严格的后序遍历）
        // 左子树：左、 右子树：右
        boolean outside = isSym(left.left, right.right);
        // 左子树：右、 右子树：左
        boolean inside = isSym(left.right, right.left);
        // 左子树：中、 右子树：中（逻辑处理）
        boolean isSame = outside && inside;

        return isSame;

    }
}
