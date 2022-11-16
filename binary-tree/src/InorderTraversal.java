import treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    //非递归方式
    //首先遍历到的元素未必是需要先处理的元素（指放入结果集中），借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。
    public static List<Integer> inorderTraversalByStackAndPointer(TreeNode root, List<Integer> res) {

        Deque stack = new ArrayDeque();
        TreeNode pointer = root;


        //当指针为空且栈为空时，退出循环，反之指针不是空或栈不是空则一直循环
        while (pointer != null || !stack.isEmpty()) {

            //指针不为空，压栈
            if (pointer != null) {
                stack.push(pointer);
                //指向左孩子
                pointer = pointer.left;

            } else {//为空

                //弹栈
                pointer = (TreeNode) stack.pop();
                res.add(pointer.val);
                //指向右孩子
                pointer = pointer.right;
            }

        }

        return res;
    }
}
