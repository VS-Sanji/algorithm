import treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class AverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        List<Double> lists = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            int count = size;
            double sum = 0;


            while (size > 0) {

                TreeNode poll = queue.poll();
                sum += poll.val;
                size--;
                if (size == 0) {
                    double ave = (double) sum / count;
                    lists.add(ave);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }

        }

        return lists;
    }
}
