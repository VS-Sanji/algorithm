import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 */
public class Postorder {
    public List<Integer> postorder(Preorder.Node root) {
        List<Integer> list = new ArrayList<>();
        postorderN(root, list);

        return list;
    }

    public void postorderN(Preorder.Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        for (Preorder.Node node : root.children) {
            postorderN(node, list);
        }
        list.add(root.val);
    }

}
