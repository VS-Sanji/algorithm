import treenode.TreeNode;

import java.util.*;

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

        Deque<TreeNode> stack = new LinkedList<>();
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

    //非递归的统一方式 利用栈和空指针标记
    public static List<Integer> inorderTraversalByStackAndNull(TreeNode root, List<Integer> res) {

        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return res;
        }

        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode cur = (TreeNode) stack.peek();
            if (cur != null) {
                stack.pop(); //将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中

                if (cur.right != null) {stack.push(cur.right);}//添加右节点（空节点不入栈）

                stack.push(cur);//添加中节点
                stack.push(null);//中节点访问过，但是还没有处理，加入空节点做为标记。

                if (cur.left != null) {stack.push(cur.left);}//添加左节点（空节点不入栈）

            } else {// 只有遇到空节点的时候，才将下一个节点放进结果集

                stack.pop();//弹出null
                TreeNode need = (TreeNode) stack.pop();//弹出该入结果集的节点
                res.add(need.val);//存入结果集
            }
        }

        return res;
    }
}
