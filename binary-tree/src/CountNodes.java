import treenode.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        //遇到null节点，返回0
        if (root == null) return 0;
        //遇到左右子树是满二叉树时，可以求其深度然后根据 公式 2^k - 1来计算节点个数
        TreeNode left = root.left, right = root.right;
        int leftDepth = 0, rightDepth = 0;//初始化为0所表示的深度是为了方便后面 用来计算总个数的，因为 2^2 = 2 << 1
        while (left != null) {
            left = left.left;
            leftDepth++;
        }

        while (right != null) {
            right = right.right;
            rightDepth++;
        }

        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;//注意括号
        }
        //以上是 整个递归函数的终止条件，包含了子树是满二叉树的情况


        //求左
        int leftCounts = countNodes(root.left);
        //求右
        int rightCounts = countNodes(root.right);
        //处理 ‘中’，返回总个数
        return leftCounts + rightCounts + 1;

    }

}
