import treenode.TreeNode;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *      节点的左子树仅包含键 小于 节点键的节点。
 *      节点的右子树仅包含键 大于 节点键的节点。
 *      左右子树也必须是二叉搜索树。
 */
public class ConvertBST {

    /**
     * 对于二叉搜索树，可以将其想象成一个有序的数组来进行考虑
     * 这里我们要将当前节点的值修改为 大于当前节点值的所有节点值 再加上 当前值 之和
     * 等同于将有序数组中当前元素的所有后元素加到当前值上，可以采用双指针来完成这一过程，同样的，在二叉树中也可以采用双指针来操作
     * 对于数组是从后往前，那么对于二叉搜索树就是 右中左 的遍历顺序
     */
    public TreeNode convertBST(TreeNode root) {
        convertBSTTree(root);
        return root;
    }

    //返回值：void，不需要返回值，因为这种题只要要求修改数值即可，不需要返回什么给上一层操作
    //两个指针
    int cur = 0;//记录当前节点的值
    int pre = 0;//记录上一个节点的值
    public void convertBSTTree(TreeNode root) {
        if (root == null) return;

        //单层逻辑
        //右
        convertBSTTree(root.right);

        //中
        cur = root.val;
        cur += pre;
        root.val  = cur;
        pre = cur;

        //左
        convertBSTTree(root.left);
    }

}
