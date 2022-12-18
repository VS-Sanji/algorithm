package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void combinationSum2(int[] sortCandidates, int target, int sum, int startIndex) {

        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        //这行不能加，如果一开始只有一个元素，那么直接退出了，但是未必没有解 如 [1],1,此时就漏解了
        //if (startIndex == sortCandidates.length - 1) return;

        //处理逻辑
        for (int i = startIndex; i < sortCandidates.length; i++) {
            //半路上就发现超过target的值了，后面的递归就完全没有必要了，合理的剪枝
            if (sum + sortCandidates[i] > target) break;
            //去重，当i不是起始位置时，并且发现 当前这个数等于前一个数，那么就需要去重，跳过该论循环，但是不能拿当前于后一个数比较，因为可能会漏解
            if (i > startIndex && sortCandidates[i - 1] == sortCandidates[i]) continue;
            path.add(sortCandidates[i]);
            sum += sortCandidates[i];
            combinationSum2(sortCandidates, target, sum, i + 1);
            sum -= sortCandidates[i];
            path.removeLast();

        }

    }
}
