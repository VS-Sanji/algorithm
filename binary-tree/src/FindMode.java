import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。假定 BST 满足如下定义：
 *
 *      结点左子树中所含节点的值 小于等于 当前节点的值
 *      结点右子树中所含节点的值 大于等于 当前节点的值
 *      左子树和右子树都是二叉搜索树
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        findModeR(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    List<Integer> list = new ArrayList<>();
    int maxCount = 0;//记录目前为止的最大出现频率，如果后面还有超过该频率的元素出现，那么就将这个值进行修改
    int count = 0;//当前所遍历的元素出现的频率
    TreeNode pre = null;//指向当前节点上一个节点的指针，利用这两个指针来进行值的比较, 初始化为null，对应于cur是二叉树最左边元素的时候

    public void findModeR(TreeNode cur) {
        //递归终止条件
        if (cur == null) return;

        //左
        findModeR(cur.left);

        //中，也就是对当前节点的处理
        if (pre == null) {
            //初始
            count = 1;
        } else if (cur.val == pre.val) {
            //前后值相同
            count++;
        } else {
            //前后值不同
            count = 1;
        }

        //如果当前的最大频率maxCount 等于 目前元素的出现频率 count，那么就将该元素存入结果集中
        //理论上来说，我们一开始并不知道maxCount的最大值，但是我们可以这么想，在不断的遍历中，都会得到一个count，可以假设最开始的count即是maxCount，
        // 在后续的遍历中，如果有更大的count出现，则修改maxCount，同时放弃之前所记录的结果集，这样只需要一次遍历就可以得到最终结果了
        if (maxCount == count) list.add(cur.val);
        //发现新的出现频率最高的count ，则修改maxCount的值，并且放弃旧记录，存入新记录
        if (maxCount < count) {
            maxCount = count;
            list.clear();
            list.add(cur.val);
        }
        //在二叉树递归遍历中，定义的两个指针pre， cur，要想让pre一直跟在cur的前面，即pre一直指向cur的上一个节点，可以这么写，是个技巧
        pre = cur;


        //右
        findModeR(cur.right);
    }
}
