/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "a";
        String s1 = reverseWords(s);
        System.out.println(s1);

    }

    public static String reverseWords(String s) {

        //校验
        if (s == null) {
            return null;
        }

        //处理字串，去除前后空格，以及中间多余空格（保留一个）
        //双指针法去除多余空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        if (start == s.length()) {
            return "";
        }
        while (s.charAt(end) == ' ') end--;

        StringBuilder trimSpaceStr = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || trimSpaceStr.charAt(trimSpaceStr.length() - 1) != ' ') {
                trimSpaceStr.append(c);
            }
            start++;
        }


        String s1 = new String(trimSpaceStr);
        char[] chars = s1.toCharArray();

        //反转trim后的字串
        int left = 0;
        int right = chars.length - 1;

        for (int i = 0; i < chars.length >> 1; i++) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];

            left++;//往右移
            right--;//往左移
        }

        trimSpaceStr = new StringBuilder(String.valueOf(chars));


        //给每个单词反转，得到最后结果
        int begin = 0;
        int last = 0;
        StringBuilder tempReStr = new StringBuilder();
        while (last < trimSpaceStr.length()) {
            if (last != trimSpaceStr.length() - 1 && trimSpaceStr.charAt(last) == ' ') {
                tempReStr.append(new StringBuilder(trimSpaceStr.substring(begin, last)).reverse());
                tempReStr.append(" ");
                begin = last + 1;
            }

            if (last == trimSpaceStr.length() - 1) {
                tempReStr.append(new StringBuilder(trimSpaceStr.substring(begin)).reverse());
            }
            last++;
        }

        return String.valueOf(tempReStr);
    }


    /**
     * 题解其一
     */
    public String reverseWords2(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }


    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
