import treenode.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class IowestCommonAncestor {


    /**
     * 分析：对于寻找最近公共祖先的问题，有两种情况
     *      1：所给的两个目标节点都各自分离，在不同的子树上
     *          这属于一般情况，我们只需要按照 左右中 后序的遍历方式进行处理，一层一层向上溯源（返回），当追溯到首个公共父节点时，这个节点就是所求的最近公共祖先
     *      2：所给的两个目标节点在同一个子树上，即其中一方可作为另一方的父节点，那么需要返回处于上层的节点即可
     *          注意：这种情况其实被 情况1 的代码所一并处理了，情况1的代码遍历到其中一个目标节点就直接返回了结果，而不用遍历到另一个节点，这与我们期望的结果是一致的
     *               如果分别遍历到了两个节点，直接视为情况一处理，否则就证明是特殊情况，返回了参数节点本身
     */

    //返回值：表示最近公共祖先
    //参数：root：表示当前节点，即根节点 p:目标节点 q:目标节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //终止条件
        if (root == null) return null;
        //找到目标节点即向上返回
        if (root.val == p.val || root.val == q.val) return root;

        //左
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        //右
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);

        //中,处理结果，如果在当前节点所拿到的左右子树所返回的结果同时不为null，说明在该节点的左右子树中找到了两个目标节点,当前这个节点就是他们的最近公共祖先
        if (leftRes != null && rightRes != null) return root;
        //如果只记录有其中一个目标节点，那么当前节点不是最近公共祖先，还需要继续往上找
        if (leftRes != null && rightRes == null) return leftRes;
        if (leftRes == null && rightRes != null) return rightRes;

        //两个结果都是空
        return null;
    }
}
