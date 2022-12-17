import treenode.TreeNode;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class TrimBST {
    //返回值：表示当前节点不在所给范围内，被删除后，其子树（可能是左子树，也可能是右子树，取决于当前节点的值与边界的关系）的新的根节点（该根节点也是修剪重构之后的根节点）
    //当需要处理的节点处理完之后，该返回值表示根节点，一层一层向上返回根节点，最终返回整棵二叉树的根节点
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            //小于low，但是其右子树可能还有符合条件的节点，但由于右子树也是一颗二叉搜索树，所以找其新根节点也是相同的逻辑，用递归处理
            TreeNode treeNode = trimBST(root.right, low, high);
            return treeNode;
        }
        if (root.val > high) {
            //大于high，但是其左子树可能还有符合条件的节点，但由于左子树也是一颗二叉搜索树，所以找其新根节点也是相同的逻辑，用递归处理
            TreeNode treeNode = trimBST(root.left, low, high);
            return treeNode;
        }

        //单层逻辑
        //处理左子树，拿到修剪后得根节点接到当前节点左边
        root.left = trimBST(root.left, low, high);
        //处理右子树，拿到修剪后得根节点接到当前节点右边
        root.right = trimBST(root.right, low, high);
        //中，返回根节点
        return root;
    }
}
