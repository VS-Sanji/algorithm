import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class Connect {

    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {

                Node poll = queue.poll();
                if (size != 1) {
                    poll.next = queue.peek();
                }
                size--;

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return root;
    }




    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
