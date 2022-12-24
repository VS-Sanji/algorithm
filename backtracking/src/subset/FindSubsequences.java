package subset;

import java.util.*;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *      对于求递增子序列的问题，不能对原数组进行排序，否则会打乱结果
 *
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequences(nums, 0);
        return res;
    }


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    //参数，原数组，一直是在原数组上操作，但是操作的部分由startIndex控制
    //startIndex:表示子数组（原数组上的子数组）的起始位置
    public void findSubsequences(int[] nums, int startIndex) {

        //在这收集结果，这是递归函数刚刚进来的时候，即上层递归加入了一个元素的结果在此进行收集
        //这行必须写在终止条件上面，不能写在下面，因为这行代码的作用是 收集
        // 上一层的结果，如果写在终止条件下面，那么对于最后一层，结果还没收集到就结束了，显然会漏解
        if (path.size() >= 2) {
            //递增子序列，起码得有两个元素
            res.add(new ArrayList<>(path));
        }

        if (startIndex >= nums.length) return;//对于子集问题，不在终止条件中收集结果，而是在递归过程中收集

        //创建map集合，用来存储每一层中已经 处理过的元素，注意是每一层，递归会产生很多层，每一层都有一个map，所以他的位置在for循环外面
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            //剪枝，path已经有元素，并且当前这个元素比它最后一个小，那么不是递增序列，直接找下一轮
            if (!path.isEmpty() && nums[i] < path.getLast()) continue;
            //去重
            /**
             * getOrDefault(key, defaultValue)这个函数的作用是：在map集合中找元素 key，
             * 如果没找到就返回默认值defaultValue,这个defaultValue是我们自己给的，那么如果返回的是我们给的这个默认值，说明map中没有我们要找的元素
             *
             * 这里map.getOrDefault(nums[i], 0) >= 1，表示同一层中找到了一个以上的目前这个值，那么就不用继续递归找解了，因为必然是重复的
             */
            if (map.getOrDefault(nums[i], 0) >= 1) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                continue;
            };

            //集合中没有与当前相同的元素，则存入当前元素
            map.put(nums[i], 1);
            path.add(nums[i]);
            //递归
            findSubsequences(nums, i + 1);
            //回溯
            path.removeLast();

        }
    }
}
