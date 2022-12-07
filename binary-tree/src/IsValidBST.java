import treenode.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *      节点的左子树只包含 小于 当前节点的数。
 *      节点的右子树只包含 大于 当前节点的数。
 *      所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {

    /**
     * 对于二叉树的递归解法，需要考虑以怎样的遍历顺序进行处理
     * 二叉搜索树的问题一般是 以 左中右 即前序遍历的方式进行处理，这样才会得到一个单调递增的数组，符合二叉搜索树的特性
     */
    //返回值表示该树是否是 二叉搜索树
    //root表示当前根节点
    //定义一个全局变量，用于记录递归中 树的一个最大值，二叉搜索树需要满足 所有左子树节点的值小于父节点的值，所有右子树节点的值大于父节点的值
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        //终止条件
        if (root == null) return true;//说明：空节点是 满二叉树，完全二叉树，二叉搜索树等,所以返回true

        //单层逻辑
        //左中右的处理顺序

        //左
        boolean left = isValidBST(root.left);
        /**
         * 可以在此做一个先行判断，当发现左子树已经不是二叉搜索树了，直接返回false，可以提高效率
         * if (!left) return false;
         */

        //中
        //先进行判断，如果发现不满足要求了返回 false
        //max != null这个条件是为了保证max不是null，即最开始时，max还没有指向任何一个节点，需要做的是给它赋值，而不是后面的判断
        //当max有值了，表明记录了最大值，才进行判断
        if (max != null && max.val >= root.val) return false;
        max = root;

        //右
        boolean right = isValidBST(root.right);

        return left && right;
        /**
         * 对应上面的，这里只返回 right即可
         * return right;
         */
    }

}
