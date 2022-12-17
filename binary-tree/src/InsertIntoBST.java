import treenode.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */
public class InsertIntoBST {

    //返回值：根节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //遍历到空节点，构造新节点，并将该节点返回给上一层调用，在上一层调用中连上该节点
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        //往左递归，插入到左子树
        if (root.val > val) {
            //拿到构造的左节点
            TreeNode left = insertIntoBST(root.left, val);
            //连上该节点
            root.left = left;

        }

        //往右递归，插入到右子树
        if (root.val < val) {
            //拿到构造的右节点
            TreeNode right = insertIntoBST(root.right, val);
            //连上该右边节点
            root.right = right;
        }

        //返回当前根节点，虽然返回的是当前的根节点，不一定是整棵二叉树的初始根节点，但是一层一层往上返回的时候，会修改root的值，最终返回的还是初始根节点
        return root;
    }

}
