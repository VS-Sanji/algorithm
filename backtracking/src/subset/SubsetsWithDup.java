package subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(nums, 0);
        return res;
    }


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    //参数，原数组，一直是在原数组上操作，但是操作的部分由startIndex控制
    //startIndex:表示子数组（原数组上的子数组）的起始位置
    public void subsets(int[] sortedNums, int startIndex) {

        //在这收集结果，这是递归函数刚刚进来的时候，即上层递归加入了一个元素的结果在此进行收集
        //对于最开始入函数的时候，这个对应的是一个空集，收集空集为一个结果
        //这行必须写在终止条件上面，不能写在下面，因为这行代码的作用是 收集
        // 上一层的结果，如果写在终止条件下面，那么对于最后一层，结果还没收集到就结束了，显然会漏解
        res.add(new ArrayList<>(path));

        /**
         * 这行终止条件可以不写，因为在下面的for中，递归调用是需要满足条件的，当i的值小于 nums.length时才会进行递归调用，
         * 当i >= nums.length时，根本就不会进行下一次递归，这时也刚好是递归该结束的时候
         * 这里写出来更加便于理解
         */
        if (startIndex >= sortedNums.length) return;//对于子集问题，不在终止条件中收集结果，而是在递归过程中收集

        for (int i = startIndex; i < sortedNums.length; i++) {
            if (i > startIndex && sortedNums[i] == sortedNums[i - 1]) {//去重逻辑
                continue;
            } else {
                path.add(sortedNums[i]);
                //递归
                subsets(sortedNums, i + 1);
                //回溯
                path.removeLast();
            }

        }
    }

    /**
     * 使用used数组来实现去重的逻辑
     * used数组是一个boolean数组，即 boolean[] used,其长度等于所给数组的长度，每一位一一标识原数组中的元素是否使用过（即处理过）
     * 对于子集问题，对应一个树形结构，去重的逻辑分别有： 树枝去重，树层去重
     * 树枝去重：对应的是纵向的，递归向下的去重，表示一个 合法结果中不能有重复元素
     * 树层去重：对应的是横向的，for循环向右的去重，表示 合法结果之间的去重
     * 依据题意，这里需要的是树层方面的去重，结果与结果之间不重复即可，每一个结果中可以有值相同的元素（如两个1，但是这两个1在原数组中是两个不同的元素，只不过值相同而已）
     */
    public void subsets(int[] sortedNums, int startIndex, boolean[] used) {

        //在这收集结果，这是递归函数刚刚进来的时候，即上层递归加入了一个元素的结果在此进行收集
        //对于最开始入函数的时候，这个对应的是一个空集，收集空集为一个结果
        //这行必须写在终止条件上面，不能写在下面，因为这行代码的作用是 收集
        // 上一层的结果，如果写在终止条件下面，那么对于最后一层，结果还没收集到就结束了，显然会漏解
        res.add(new ArrayList<>(path));

        /**
         * 这行终止条件可以不写，因为在下面的for中，递归调用是需要满足条件的，当i的值小于 nums.length时才会进行递归调用，
         * 当i >= nums.length时，根本就不会进行下一次递归，这时也刚好是递归该结束的时候
         * 这里写出来更加便于理解
         */
        if (startIndex >= sortedNums.length) return;//对于子集问题，不在终止条件中收集结果，而是在递归过程中收集

        for (int i = startIndex; i < sortedNums.length; i++) {
            //去重逻辑，!used[i - 1]表示前一位未使用，如[0,1,0],表示的是第二个分支，如果原数组中第二个元素与第一个元素相同，那么这个分支是要去重的
            //                                   而[1,1,0],表示的是第一个分支，其中的第一个元素取了，第二个元素也取了的情况，这是在同一个支树上
            if (i > 0 && sortedNums[i] == sortedNums[i - 1] && !used[i - 1]) {
                continue;
            } else {
                path.add(sortedNums[i]);
                //标记当前元素已经记录
                used[i] = true;
                //递归
                subsets(sortedNums, i + 1);
                //标记当前元素下属情况已经在递归中处理完，要往回寻找其它分支，所以需要将此时的used数组的值重新置为false
                used[i] = false;
                //回溯
                path.removeLast();
            }

        }
    }
}

