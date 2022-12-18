package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        letterCombinations(digits, numString, 0);
        return res;

    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    //digits表示传入的数字字符串，index表示该字符串中的第几个元素
    public void letterCombinations(String digits, String[] numString, int index) {

        //终止条件，每个数字都要取一个字母，那么有几个数字，最终的结果就是几个字母的集合，即sb的长度等于 digits的长度时，就可以收获结果了，此时已经递归到树的叶子节点了
        if (sb.length() == digits.length()) {
            res.add(new String(sb));
            return;
        }

        //str 表示当前index下所对应的字符串
        String str = numString[digits.charAt(index) - '0'];

        //处理逻辑
        //for循环控制横向遍历，其中的递归自调用控制递归深度遍历
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            letterCombinations(digits, numString, index + 1);
            //回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
