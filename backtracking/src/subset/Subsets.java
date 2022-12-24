package subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    //参数，原数组，一直是在原数组上操作，但是操作的部分由startIndex控制
    //startIndex:表示子数组（原数组上的子数组）的起始位置
    public void subsets(int[] nums, int startIndex) {

        //在这收集结果，这是递归函数刚刚进来的时候，即上层递归加入了一个元素的结果在此进行收集
        //对于最开始入函数的时候，这个对应的是一个空集，收集空集为一个结果
        //这行必须写在终止条件上面，不能写在下面，因为这行代码的作用是 收集上一层的结果，如果写在终止条件下面，那么对于最后一层，结果还没收集到就结束了，显然会漏解
        res.add(new ArrayList<>(path));

        /**
         * 这行终止条件可以不写，因为在下面的for中，递归调用是需要满足条件的，当i的值小于 nums.length时才会进行递归调用，
         * 当i >= nums.length时，根本就不会进行下一次递归，这时也刚好是递归该结束的时候
         * 这里写出来更加便于理解
         */
        if (startIndex >= nums.length) return;//对于子集问题，不在终止条件中收集结果，而是在递归过程中收集

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            //递归
            subsets(nums, i + 1);
            //回溯
            path.removeLast();
        }
    }
}
