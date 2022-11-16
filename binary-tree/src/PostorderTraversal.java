import treenode.TreeNode;

import java.util.*;

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


    //非递归解法（利用栈数据结构来完成，递归可以转换成栈，本身也是栈结构）
    //后序遍历可以由前序遍历修改得来，前序是 中左右， 后序是 左右中，只要先压栈 左，后压 右，那么先弹 右，后弹 左，最后得到 中右左，将其反转就得到了 左右中
    public static List<Integer> preorderTraversalByStack(TreeNode root, List<Integer> list) {
        //后序遍历 左右中
        Deque stack = new ArrayDeque();

        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = (TreeNode) stack.pop();
            list.add(node.val);

            //先压 左
            if (node.right != null) {
                stack.push(node.right);
            }

            //后压右
            if (node.left != null) {
                stack.push(node.left);
            }

        }

        Collections.reverse(list);
        return list;
    }
}
