import treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树之前序遍历
 */
public class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    //二叉树的前序遍历
    //递归解法

    /**
     * 递归三步走
     * 1.明确递归函数的功能（这里是按照前序遍历），确定其 方法参数 和 返回值（这里参数需要一个根节点，然后不要返回值，我们将结果存入一个集合中，用这个集合参数来保存结果）
     *      确定递归函数的参数和返回值： 确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数， 并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
     * 2.分析递归退出条件，这里的话，按照前序遍历的规则，当根节点是null时，说明已经遍历到底了，可以结束递归过程
     *      确定终止条件： 写完了递归算法, 运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的不对，
     *      操作系统也是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。
     * 3.补充单层递归逻辑，这里根据前序遍历的规则，首先存根节点值，然后存左节点的值，然而左节点可能会衍生出一个树，所以还需要求这个左子树的前序遍历结果
     *      **那么正好，当前我们所写的这个函数就是用来处理前序遍历的函数，自己调用自己进行处理**，preorderTraversal(root.left, res);这行代码执行完表示 左处理完了，接下来处理右
     *      同理，preorderTraversal(root.right, res);
     *          这么写完以后，就是一个完整的单层递归的逻辑
     */

    //递归解法
    public static void preorderTraversal(TreeNode root, List<Integer> res) {

        //终止条件
        if (root == null) {
            return;
        }

        //单层逻辑，自己调用自己来完善单层逻辑
        //自己调用自己，只是参数变为子问题需要的参数，完成递归函数的补完
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }

    //非递归解法（利用栈数据结构来完成，递归可以转换成栈，本身也是栈结构）
    public static List<Integer> preorderTraversalByStack(TreeNode root, List<Integer> list) {
        //前序遍历 中左右
        Deque stack = new ArrayDeque();

        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = (TreeNode) stack.pop();
            list.add(node.val);

            //因为结果要的是 左右，所以先压栈右
            if (node.right != null) {
                stack.push(node.right);
            }

            //后压栈左
            if (node.left != null) {
                stack.push(node.left);
            }

        }

        return list;
    }



}
