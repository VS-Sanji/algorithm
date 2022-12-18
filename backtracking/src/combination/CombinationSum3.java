package combination;

import java.util.*;

/**
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        combine(0, k, n, 1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    //path，路径，表示一个合法结果
    LinkedList<Integer> path = new LinkedList<>();
    public void combine(int targetSum, int k, int sum, int startIndex) {

        //终止条件
        //剪枝，当sum已经大于targetSum的时候，就不用继续找结果了，一定是不符合要求的，没有意义，直接return
        if (targetSum > sum) return;
        if (path.size() == k) {
            if (targetSum == sum) {
                res.add(new ArrayList<>(path));
                return;
            }
        }


        //i <= 9 - (k - path.size() + 1),这里也是做剪枝，为了符合个数要求，部分过程是完全不必要的，如还需要5个元素，[1,9]中，当startIndex最多就只能从5开始，往后以6，7，8，9开始的都是不合个数要求，完全没必要找
        for (int i = startIndex; i <= 9 - (k - path.size() + 1); i++) {
            //存入选择的值
            path.add(i);
            sum += i;
            //递归处理子问题，这行结束就已经收集了一个结果了
            combine(targetSum, k, sum, i + 1);
            //收集完一个结果后，需要回溯一下，清除最后加入的元素，以便正确收集下一个结果，如 [1,2] -> [1] -> [1,3]
            //回溯,对称于递归自调用上面的代码，往回倒
            sum -= i;
            path.removeLast();
        }
    }
}
