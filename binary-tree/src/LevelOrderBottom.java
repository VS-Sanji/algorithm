import treenode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * Deque的可以用来模拟 栈、队列、双端队列
 * 用作栈时，其方法为 push、pop、peek
 * 用作队列时，其方法为 add(E e) / offer(E e)、	E remove() / E poll()、E element() / E peek()
 * 用作双端队列时，其方法为 addLast(E e) / offerLast(E e)、E removeFirst() / E pollFirst()、E getFirst() / E peekFirst()
 *                     addFirst(E e) / offerFirst(E e、E removeLast() / E pollLast()、E getLast() / E peekLast()
 */
public class LevelOrderBottom {


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        Deque<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> lists = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> integers = new ArrayList<>();
            int size = queue.size();

            while (size > 0) {

                TreeNode poll = queue.poll();
                integers.add(poll.val);
                size--;

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            //加入到结果集的最头上，最终的集合就是一个从底层往顶层遍历的结果
            lists.add(0, integers);

        }

        return lists;
    }

}
