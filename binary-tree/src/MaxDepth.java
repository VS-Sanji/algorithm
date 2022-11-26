import treenode.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {

    //二叉树的最大深度，其值等于其最大高度，一个从根往下计数，一个从底往上计数
    //采用左右中的遍历，处理完子节点将此时最大高度返回给中间父节点，依次往上直到最终的根节点，其高度就是最大深度
    public int maxDepth(TreeNode root) {

        //已经到达null了，返回0
        if (root == null) return 0;

        //左树高
        int leftDepth = maxDepth(root.left);
        //右树高
        int rightDepth = maxDepth(root.right);
        //取较大者
        int depth = 1 + Math.max(leftDepth, rightDepth);
        return depth;
    }
}
