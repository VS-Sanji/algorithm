import treenode.TreeNode;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class HasPathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        //将 树根节点为 null的情况与递归过程分离，递归时就不用考虑 空节点入递归的情况
        if (root == null) return false;
        return hasPathSumR(root, targetSum);
    }

    //思路：拿到一个sum，从树的根节点往下遍历，可以拿这个sum减去当前节点的数值，然后只要找 子树中有没有这个差值即可，一直向下，如果最终 被减为0，说明有这么一条路径
    //递归函数的返回值表示最终有没有这么一条路径，参数需要一个根节点，一个目标值
    public boolean hasPathSumR(TreeNode root, int targetSum) {

        /**
         * 如果这个函数添加上判空的情况，那么就不用写上面的函数，单独处理空了
         * if (root == null) return false; 这一行代码只会在 首次调用传参的时候执行，即只起到判断 树根节点 的情况，
         * 在后续的递归调用中，不会执行，因为后续的递归调用都是在排除空节点的时候调用的
         */

        //终止条件，最小子问题解决了即可返回
        targetSum -= root.val;
        //叶子节点
        if (root.left == null && root.right == null) return targetSum == 0;

        if (root.left != null) {
            //这里入递归的节点，永远不是空节点，因为做了判断
            boolean zero = hasPathSum(root.left, targetSum);
            if (zero) return true;
        }

        if (root.right != null) {
            boolean zero = hasPathSum(root.right, targetSum);
            if (zero) return true;
        }

        return false;
    }

}
