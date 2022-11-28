import treenode.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 就是求左右子树高度差 -> 求左右子树高度
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        //当能顺利求出高度时，证明在递归过程中没有发现有子树高度差大于1的情况，说明这是一棵平衡二叉树
        //即，如果得不到正确的高度，表明一定出了问题，不是平衡二叉树
        return getHeight(root) != -1;
    }

    //该函数用来求二叉树高度
    //注意其中的特殊处理，当返回高度为 -1 时，表示不是平衡二叉树
    //子树非平衡二叉树，那么整棵树也不是平衡二叉树
    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        //后序遍历求以该节点为根节点的子树的高度
        int leftHeight = getHeight(root.left);
        //子树不是平衡二叉树，返回-1
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        //特殊处理，当发现有某棵树左右子树高度差大于 1， 返回-1，表示其不是平衡二叉树
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
