/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 *      输入: s = "abcdefg", k = 2
 *      输出: "bacdfeg"
 */
public class ReverseStr {


    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i;
            int right;
            //最后一段
            if (s.length() - i <= k) {
                for (int j = 1; j <= (s.length() - i) >> 1; j++) {
                    right = s.length() - j;
                    chars[left] ^= chars[right];
                    chars[right] ^= chars[left];
                    chars[left] ^= chars[right];
                    left++;
                }
                //直接返回
                return new String(chars);
            }

            //一般情况，未到最后
            for (int j = 1; j <= (k >> 1); j++) {
                right = i + k - j;
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left++;
            }
        }
        s = new String(chars);
        return s;
    }

    //题解，更简洁
    public static String reverStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
