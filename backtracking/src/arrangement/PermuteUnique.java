package arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permuteUnique(nums, new boolean[nums.length]);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void permuteUnique(int[] sortedNums, boolean[] used) {

        if (path.size() == sortedNums.length) {
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
        for (int i = 0; i < sortedNums.length; i++) {
            //当前元素取用过了，不能再用，跳过
            if (used[i]) continue;
            //非头元素，后一个元素与前一个元素相同，并且前一个元素未用过（保证在树形结构中同一层，前一个元素的分支已经全部处理完了，
            // 回溯到这里),这时当前分支的结果都在上一个分支中全部收集了，不能重复取，跳过
            if (i > 0 && sortedNums[i] == sortedNums[i - 1] && !used[i - 1]) continue;
            //取值
            path.add(sortedNums[i]);
            used[i] = true;
            //递归
            permuteUnique(sortedNums, used);
            //回溯
            used[i] = false;
            path.removeLast();

        }
    }
}
