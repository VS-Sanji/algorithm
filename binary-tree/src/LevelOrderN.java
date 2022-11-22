import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 */
public class LevelOrderN {


    public static List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        Deque<Node> queue = new ArrayDeque<>();

        List<List<Integer>> lists = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> integers = new ArrayList<>();
            int size = queue.size();

            while (size > 0) {

                Node poll = queue.poll();
                integers.add(poll.val);
                for (Node child : poll.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }

                size--;
            }

            lists.add(integers);

        }

        return lists;

    }





    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
