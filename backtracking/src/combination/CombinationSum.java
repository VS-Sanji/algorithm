package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //对所给数组排序，从小到大
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0);
        return res;
    }

    //全局变量
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    //回溯函数（递归）
    //参数：candidates：按照从小到大排序后的数组，便于剪枝处理
    //target：目标和
    //sum：当前已收集元素的和
    //startIndex：遍历查找的起始位置（从哪个数开始找结果）
    public void combinationSum(int[] candidates, int target, int sum, int startIndex) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        //处理逻辑
        for (int i = startIndex; i < candidates.length; i++) {//for循环控制的是横向的遍历，即从左至右的一个遍历顺序

//        for (int i = startIndex; i < candidates.length && sum + candidates[i] < target; i++) {//可以写在for循环括号内，但是这种方式不方便理解，所以可以写在里面，本质就是 当前sum 加上目前这个值已经大于target了，就直接不用找了，break掉

            // 如果 sum + candidates[i] > target 就终止遍历
            // 这个if判断是一个剪枝的操作，剪枝的操作应该是放在for循环中来控制的，为了便于理解，写在for循环里面
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            sum += candidates[i];
            //递归处理后续子问题
            combinationSum(candidates, target, sum, i);//这里的关键参数，startIndex为什么传i呢，因为题目说了可以取重复的值，那么可以取为i，此时startIndex的值就跟着i变化
            //回溯
            sum -= candidates[i];
            path.removeLast();
        }
    }

}
