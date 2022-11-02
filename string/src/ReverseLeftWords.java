/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", n = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", n = 6
 * 输出: "umghlrlose"
 *
 * 可以使用局部反转 + 整体反转这样一个思路
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        String s1 = reverseLeftWords(s, n);
        System.out.println(s1);
    }

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();

        int times = n >> 1;
        int left = 0;
        int right = n - 1;
        reverse(chars, left, right, times);

        times = (s.length() - n) >> 1;
        left = n;
        right = s.length() - 1;
        reverse(chars, left, right, times);

        times = s.length() >> 1;
        left = 0;
        right = s.length() - 1;
        reverse(chars, left, right, times);

        return new String(chars);

    }

    public static void reverse(char[] chars, int left, int right, int times) {
        int i = 1;
        while (i <= times) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
            i++;
        }
    }


}
