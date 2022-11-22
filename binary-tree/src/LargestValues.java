import treenode.TreeNode;

import java.util.*;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class LargestValues {

    public static List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        List<Integer> lists = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            int max = queue.peek().val;

            while (size > 0) {

                TreeNode poll = queue.poll();
                if (poll.val > max) {
                    max = poll.val;
                }
                size--;

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            lists.add(max);

        }

        return lists;

    }
}
