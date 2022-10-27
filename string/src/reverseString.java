/**
 * 给一个字符串，将其反转，要求不适用额外的空间
 */
public class reverseString {

    public static void reverseString(char[] s) {

        int left = 0;//指向头
        int right = s.length - 1;//指向尾

        for (int i = 0; i < s.length >> 1; i++) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];

            left++;//往右移
            right--;//往左移
        }
    }
}
