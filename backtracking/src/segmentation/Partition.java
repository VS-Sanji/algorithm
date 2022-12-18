package segmentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Partition {


    /**
     * 思路：
     *      1.切分，分割问题也是归为一类回溯问题，也可以套用回溯算法的解决模板，关键还是提炼出 该问题的一个 树形结构
     *      2.类比于组合问题，我们可以这么考虑
     *          题目所给的意思，可以等同于 给一个字符串，划分出n个子串，如果这些子串都是回文串，那么记录这个组合为一个分割方案
     *          那么如果划分呢？要想找到所有的分割方案，那么就需要一个一个的试过去，为了不漏掉某些可能的方案，可以这么处理
     *              拿到一个字符串（可以是分割后的子串），对这个字符串进行处理时，
     *
     *              以下是拿到一个字符串（可以是分割后的子串）的单层处理逻辑
     *                  首先取其第一个元素将原字符串分为两部分，判断是否符合；（这里经过递归后，就能找出所有以单元素作为前置子串的所有可能方案）
     *                  其次取其前两个元素将原字符串分为两部分，判断是否符合；（这里经过递归后，就能找出所有以双元素作为前置子串的所有可能方案）
     *                  再次取其前三个元素将原字符串分为两部分，判断是否符合；（这里经过递归后，就能找出所有以三元素作为前置子串的所有可能方案）
     *                  、、、
     *                  依次类推，直到取原字符串作为子串为止，判断是否符合   （这里经过递归后，就能找出所有以全元素作为前置子串的所有可能方案）
     *              然后递归处理 后部分（即去掉前面所取元素的剩余部分为一整体），逻辑与上面完全相同，直到递归终止
     *
     *              最终获取到所有的可能结果
     */
    public List<List<String>> partition(String s) {
        partition(s, 0);
        return res;
    }

    //全局变量
    List<List<String>> res = new ArrayList<>();//存放最后的所有可能方案
    LinkedList<String> path = new LinkedList<>();//存放一条可能方案

    /**
     * 回溯函数，用来求所有可能方案
     * @param s 上层传入的子串（对于开始就是整个字串）
     * @param startIndex 切分下标,这个startIndex最开始是传入一个初始值（最开始是手动传的0），但在后续递归中，取的是 for中定义的 变量 i，i从startIndex一直往后递增，对应的是横向的遍历
     */
    public void partition(String s, int startIndex) {

        //切分到最后了
        /**
         * 注意这里startIndex的取值，只有当它 等于 s.length()时，才算结束，因为在横向遍历的for()中，startIndex最大为 s.length() - 1，
         * 要记录最后一条结果时，需要进入递归的终止条件，那么在partition(s, i + 1);中所传进来的 startIndex的值是 s.length();
         * 所以这里的判断条件 要设置为if (startIndex == s.length())，而不是 startIndex == s.length() - 1，否则会漏掉一个子串
         */
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        //这个for中，根据i的值来进行横向的遍历
        for (int i = startIndex; i < s.length(); i++) {
            //判断是否是回文串，单独写个函数，在这调用即可
            if (isPalindrome(s, startIndex, i)) {
                //头部分是回文串，存入path中
                path.add(s.substring(startIndex, i + 1));
            } else continue;//不是回文串，继续求下一组

            //递归处理子串，递归负责纵向的遍历
            //起始位置后移
            partition(s, i + 1);

            //回溯
            path.removeLast();
        }

    }

    /**
     * 判断是否是回文字串函数
     * @param s 待判断字符串
     * @param begin 左界，闭区间
     * @param end 右界，闭区间
     * @return 结果
     */
    //双指针法
    public boolean isPalindrome(String s, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }



}
