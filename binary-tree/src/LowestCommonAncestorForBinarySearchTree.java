import treenode.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class LowestCommonAncestorForBinarySearchTree {

    /**
     * 因为根据二叉搜索树的特点，根节点大于左子树，小于右子树，在中间就是最近公共祖先，不论是是继续往左还是往右遍历，都只能找到一个目标节点，所以不可能是最近公共节点
     */

    //返回值：表示最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遇到空节点，返回，但其实并不需要，因为题目说了一定会有结果
        //对于一定会有结果的问题，递归中可以不用写终止条件，因为一定会找到结果从而自己结束
        if (root == null) return null;

        //左，这两个节点都在根节点左边，只需要往左搜索递归
        if (root.val > p.val && root.val > q.val) {
             TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
             if (leftRes != null) return leftRes;
        }

        //右，这两个节点都在根节点右边，只需要往右搜索递归
        if (root.val < p.val && root.val < q.val) {
            TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
            if (rightRes != null) return rightRes;
        }

        //其它情况：
        /**
         * 1.包括root节点在p，q之间，即root是最近公共父节点，这时符合要求直接返回root
         * 2.root节点是p、q其中之一，同样符合题意，此时的root也是最近公共父节点，直接返回即可
         */
        return root;

    }


}
