import treenode.TreeNode;

import java.util.*;

/**
 * 层序遍历
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        //传入null，直接返回
        if (root == null) {
            return lists;
        }

        //将初始根节点入队列
        queue.offer(root);
        //记录size，该size表示该层的节点数
        int size = queue.size();
        //队列非空，则继续循环
        while (!queue.isEmpty()) {

            //该节点有左节点
            if (queue.peek().left != null) {
                //将左节点加入到队列尾
                queue.offer(queue.peek().left);
            }

            //该节点有右节点
            if (queue.peek().right != null) {
                //将该右节点加入到队列尾
                queue.offer(queue.peek().right);
            }

            //弹出该节点
            TreeNode poll = queue.poll();
            //往集合中存入当前节点的值
            integers.add(poll.val);
            //size--动作表示该层已经记录了一个元素，还有size--个元素
            size--;

            //当size=0，表示该层所有元素都已经遍历过，需要将记录了该层元素的集合加入到结果集中
            if (size == 0) {
                //将该层的结果加入到结果集中
                //new ArrayList<>(integers)，构造一个含有integers中元素的新集合加入到结果集中，因为integers后面还要继续用，所以不能直接加入
                lists.add(new ArrayList<>(integers));
                //清空当前的integers，去记录后面每一层的元素
                integers.clear();
                //因为前面在弹出每一个节点之前，都往队列中加入了其左右节点，当前队列中所有节点都是下一层的，所以size=queue.size表示重置为下一层的元素个数
                size = queue.size();
            }

        }

        return lists;

    }
}
