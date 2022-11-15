import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
public class PostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }


    public static void postorderTraversal(TreeNode root, List<Integer> res) {

        //终止条件
        if (root == null) {
            return;
        }

        //单层逻辑，自己调用自己来完善单层逻辑
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }
}
