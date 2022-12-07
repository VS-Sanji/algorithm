import treenode.TreeNode;

/**
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class MergeTrees {

    /**
     * 返回值treenode：表示合并二叉树的根节点
     * 参数：root1，root2表示所参与合并的两颗原始二叉树的根节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //终止条件，当参数根节点为null时，表明当前位置没有元素，对于最终的合并二叉树，需要返回另外一颗的值作为最终结果
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        //单层循环逻辑，构建合并二叉树，可以直接修改树root1，也可以重新构建一棵树，这里就重新构建了
        //这是根
        TreeNode mergeTree = new TreeNode(root1.val + root2.val);

        //左子树
        mergeTree.left = mergeTrees(root1.left, root2.left);
        //右子树
        mergeTree.right = mergeTrees(root1.right, root2.right);

        return mergeTree;
    }

    /**
     * 迭代法
     *
     *      public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
     *         if (root1 == null) return root2;
     *         if (root2 ==null) return root1;
     *
     *         Queue<TreeNode> queue = new LinkedList<>();
     *         queue.offer(root1);
     *         queue.offer(root2);
     *
     *         while (!queue.isEmpty()) {
     *
     *             TreeNode node1 = queue.poll();
     *             TreeNode node2 = queue.poll();
     *             // 此时两个节点一定不为空，val相加
     *             node1.val = node1.val + node2.val;
     *
     *             // 如果两棵树左节点都不为空，加入队列
     *             if (node1.left != null && node2.left != null) {
     *                 queue.offer(node1.left);
     *                 queue.offer(node2.left);
     *             }
     *             // 如果两棵树右节点都不为空，加入队列
     *             if (node1.right != null && node2.right != null) {
     *                 queue.offer(node1.right);
     *                 queue.offer(node2.right);
     *             }
     *             // 若node1的左节点为空，直接赋值
     *             if (node1.left == null && node2.left != null) {
     *                 node1.left = node2.left;
     *             }
     *             // 若node2的左节点为空，直接赋值
     *             if (node1.right == null && node2.right != null) {
     *                 node1.right = node2.right;
     *             }
     *         }
     *         return root1;
     *     }
     */
}
