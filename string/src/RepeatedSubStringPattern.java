import java.util.Arrays;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 *
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 */
public class RepeatedSubStringPattern {

    //移动匹配
    //当一个字符串由重复子串构成时，那么将两个该字符串拼接起来，在中间部分（出去头元素，尾部元素，为了保证不是原先的两个字串）一定能够找到一段子串 与 该字符串相同
    //如 “abcabc” + “abcabc” -> "abcabcabcabc" 掐头去尾 -> "bcabcabcab" ,在其中能够找到一段 “abcabc”与原来的字串相同
    public static boolean repeatedSubStringPattern(String s) {

        String newStr = s + s;
        String subStr = newStr.substring(0, newStr.length() - 1);
        if (subStr.contains(s)) return true;

        return false;
    }


    //KMP解法

    /**
     * s是重复字串 <=> s的最大相同前后缀所不包含的部分是最小重复子串 <=> s.len % (s的最大相同前后缀所不包含的部分长）= 0
     * 所以只要求出s的最大相同前后缀所不包含部分长，判断其是不是能够被s.len整除，能被整除就能反推回去s是重复字串
     */
    public static boolean repeatedSubStringPatternKMP(String s) {

        int[] next = getNext(s);
        //最大相等前后缀的长度
        int max = next[s.length() - 1];

        //排除最大相等前后缀等于0的情况，因为等于0时，s.length() % (s.length() - max) == 0恒成立
        if (max != 0 && s.length() % (s.length() - max) == 0) {
            return true;
        }

        return  false;
    }

    //求next数组
    public static int[] getNext(String s) {

        char[] chars = s.toCharArray();
        int[] next = new int[s.length()];

        int j = 0;//初始化前缀尾（还表示当前位置的字串的最大相等前后缀的长度）
        next[0] = 0;//初始化next首元素
        for (int i = 1; i < s.length(); i++) {//后缀尾

            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }

            if (chars[i] == chars[j]) {
                j++;
                next[i] = j;
            }
        }

        return next;
    }
}
