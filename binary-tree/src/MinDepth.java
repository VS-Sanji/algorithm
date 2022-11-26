import treenode.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinDepth {

    //不管是最大深度还是最小深度，都指的是从根节点到叶子节点的，什么是叶子节点，就是没有左右子节点的节点
    public int minDepth(TreeNode root) {
        //已经到达null了，返回0
        if (root == null) return 0;

//        //左树高
//        int leftDepth = minDepth(root.left);
//        //右树高
//        int rightDepth = minDepth(root.right);
//        //取较小者
//        int depth = Math.min(leftDepth, rightDepth);

        //左子节点为null，右子节点不为null，返回 1 + rightDepth
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);

        } else if (root.left != null && root.right == null) {//左子节点为null，右子节点不为null，返回 1 + leftDepth
            return 1 + minDepth(root.left);

        } else if (root.left != null && root.right != null) {//左右子节点均不为null，返回 1 + Math.min(leftDepth, rightDepth)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));

        } else {//左右子节点均为null，说明这是 叶子节点，返回 1
            return 1;
        }
    }
}
