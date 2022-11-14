import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }


    public static void inorderTraversal(TreeNode root, List<Integer> res) {

        //终止条件
        if (root == null) {
            return;
        }

        //单层逻辑，自己调用自己来完善单层逻辑
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}
