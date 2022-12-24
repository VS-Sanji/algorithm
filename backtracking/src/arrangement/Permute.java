package arrangement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  全排列，即 每一个合法结果是原来数组中所有元素的排列，所以对应树形结构中，是在叶子节点上进行结果的收集，当path的size等于数组的长度时，就可以收集返回了
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new boolean[nums.length]);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void permute(int[] nums, boolean[] used) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //排列问题，强调顺序，如 [1,2],[2,1]是两个 结果，这与 组合是不同的，组合问题不强调顺序
        /**
         * 在递归回溯过程中，传递的一直是原数组nums，只不过用used数组中的值来决定是否 取当前数，亦或是跳过
         * nums[1,2,3]
         * used[1,0,0]
         * 则表明nums中第一个元素已经取过了，要访问的是后面两个元素[2,3]
         */
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //取值
            path.add(nums[i]);
            used[i] = true;
            //递归
            permute(nums, used);
            //回溯
            used[i] = false;
            path.removeLast();

        }
    }
}
