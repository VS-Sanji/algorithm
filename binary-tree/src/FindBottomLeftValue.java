import treenode.TreeNode;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class FindBottomLeftValue {

    int maxDepth = Integer.MIN_VALUE;//设置一个初始值
    int result;//取最终结果
    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        findBottomLeftValue(root, maxDepth);
        return result;
    }



    //递归解法，递归函数
    /**
     * 思路：一颗二叉树，要求其 最底层，最左边 节点的值。首先明确什么是最左边的值，一定是左节点的值吗，不一定，有可能是最后一层的右节点的值
     *      一个需要是最底层，所以联想到需要一个 描述深度的变量，且是在递归过程中具有全局性的，这是为了找最底层
     *      一个是左优先，如果最后一层有左节点，那么最左边的节点一定不会是右节点，所有前中后序遍历都可以，左永远比右先遍历处理
     *
     *      函数需要返回值吗，不需要，因为最终只找一个值，找到即可，不需要向上返回
     *      函数参数，肯定需要一个根节点root，另外还需要传进来描述 当前深度的变量depth
     */
    public void findBottomLeftValue(TreeNode root, Integer depth) {
        //递归终止条件（最小子问题）
        if (root == null) return;
        if (root.left == null && root.right == null) {//是叶子节点，需要统计最大深度
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
            return;//终止递归了
        }

        //执行到这，不用考虑终止条件下的情况，上面已经考虑过了
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }


}
