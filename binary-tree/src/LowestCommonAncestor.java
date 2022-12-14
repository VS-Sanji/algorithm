import treenode.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {


    /**
     * 分析：对于寻找最近公共祖先的问题，有两种情况
     *      1：所给的两个目标节点都各自分离，在不同的子树上
     *          这属于一般情况，我们只需要按照 左右中 后序的遍历方式进行处理，一层一层向上溯源（返回），当追溯到首个公共父节点时，这个节点就是所求的最近公共祖先
     *      2：所给的两个目标节点在同一个子树上，即其中一方可作为另一方的父节点，那么需要返回处于上层的节点即可
     *          注意：这种情况其实被 情况1 的代码所一并处理了，情况1的代码遍历到其中一个目标节点就向上返回结果，对于情况二没有遍历到另外一个节点，但是不影响最终的结果，这与我们期望的结果是一致的
     *               如果分别遍历到了两个节点，直接视为情况一处理，否则就证明是特殊情况，返回了参数节点本身
     */

    /**
     * 1.求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从低向上的遍历方式。
     *
     * 2.在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
     *
     * 3.要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果
     */

    //返回值：表示最近公共祖先
    //需要递归函数返回值，来告诉我们是否找到节点q或者p，那么返回值为bool类型就可以了。但我们还要返回最近公共节点，可以利用上题目中返回值是TreeNode，那么如果遇到p或者q，就把q或者p返回，返回值不为空，就说明找到了q或者p。
    //参数：root：表示当前节点，即根节点 p:目标节点 q:目标节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //终止条件
        if (root == null) return null;
        //找到目标节点即向上返回
        if (root == p || root == q) return root;

        //左
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        //右
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);

        //中,处理结果，如果在当前节点所拿到的左右子树所返回的结果同时不为null，说明在该节点的左右子树中找到了两个目标节点,当前这个节点就是他们的最近公共祖先
        if (leftRes != null && rightRes != null) return root;
        //作用一：如果只记录有其中一个目标节点，那么当前节点不是最近公共祖先，还需要继续往上找
        //作用二：已经收集到上一行代码的结果，找到了这个最近公共节点，那么这两行代码承担的作用就是将 最近公共节点这个结果返回（传递）给上一层，直到最终返回给初始根节点，初始根节点所拿到的最终结果就是所求 最近公共虚线
        if (leftRes != null && rightRes == null) return leftRes;
        if (leftRes == null && rightRes != null) return rightRes;

        //两个结果都是空
        return null;
    }
}
