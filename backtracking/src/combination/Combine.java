package combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 1);
        return res;
    }

    //回溯算法一般也是写递归，主要在于递归内逻辑的编写，存在回溯的逻辑
    //返回值：回溯算法的返回值一般是 void
    //参数：回溯算法的参数可根据逻辑处理过程中的需要进行添加,可能一开始无法确定所有参数
    //n:表示 [1,n]区间的数
    //k:从[1,n]中找 k 个数的组合
    //startIndex:递归查找起始下标，因为组合问题是 无序的问题，不强调顺序，所有[1,2],[2,1]这种算是一个结果，为了避免重复，下标需要动态改变，以规定查找范围
    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */

    //结果集，用来保存所有结果，因为整个过程中只需要一个，所以直接new
    List<List<Integer>> res = new ArrayList<>();
    //path，路径，表示一个合法结果
    LinkedList<Integer> path = new LinkedList<>();
    public void combine(int n, int k, int startIndex) {

        //终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        /**
         * 本题还需要startIndex来控制for循环的起始位置，对于组合问题，什么时候需要startIndex呢？
         *      我举过例子，如果是一个集合来求组合的话，就需要startIndex，例如：77.组合 (opens new window)，216.组合总和III (opens new window)。
         *      如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex，例如：17.电话号码的字母组合(opens new window)
         *      注意以上我只是说求组合的情况，如果是排列问题，又是另一套分析的套路，后面我再讲解排列的时候就重点介绍。
         */

        //这里startIndex从1开始取，与集合 [1,n]相对应，方便处理
        //for (int i = startIndex; i <= n; i++) { 存在冗余查找过程，可以剪枝
        //1.已经选择的元素个数：path.size();
        //2.还需要的元素个数为: k - path.size();
        //3.在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        //      为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
        //      举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
        //      从2开始搜索都是合理的，可以是组合[2, 3, 4]。
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {//剪枝，因为 在[1,4]中取两个数的集合，按顺序遍历过去，到4，就不需要找了，只有一个元素肯定不合法，直接减除
            //存入选择的值
            path.add(i);
            //递归处理子问题，这行结束就已经收集了一个结果了
            combine(n, k, i + 1);
            //收集完一个结果后，需要回溯一下，清除最后加入的元素，以便正确收集下一个结果，如 [1,2] -> [1] -> [1,3]
            //回溯
            path.removeLast();
        }
    }

}
