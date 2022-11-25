import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 */
public class Preorder {

    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();
        preorderN(root, list);

        return list;
    }

    public void preorderN(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        for (Node node : root.children) {
            preorderN(node, list);
        }
    }


    public class Node {
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
    }
}
