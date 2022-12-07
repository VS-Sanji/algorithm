import treenode.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 *
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 */
public class SearchBST {

    //返回值是 树的根节点
    public TreeNode searchBST(TreeNode root, int val) {
        //终止条件
        if (root == null || root.val == val) return root;

        //单层逻辑
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        return null;

        /**
         * 迭代法
         */
//        while (root != null) {
//            if (val < root.val) {
//                root = root.left;
//            } else if (val > root.val) {
//                root = root.right;
//            } else return root;
//        }
//        return null;
    }

}
