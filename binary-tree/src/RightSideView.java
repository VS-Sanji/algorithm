import treenode.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        List<Integer> lists = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            //记录每一层的最右节点，即队列中的队首元素
            TreeNode peek = queue.peek();

            while (size > 0) {

                TreeNode poll = queue.poll();
                //当弹出的是队首元素时，记录值
                if (poll == peek) {
                    lists.add(poll.val);
                }
                size--;

                if (poll.right != null) {
                    queue.offer(poll.right);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
            }
            
        }

        return lists;

    }

}
