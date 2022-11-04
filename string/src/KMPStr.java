import java.util.Arrays;

/**
 * 经典KMP算法
 *
 */
public class KMPStr {

    public static void main(String[] args) {
        String s = "aabaaf";
        int[] next = getNext(s);
        System.out.println(Arrays.toString(next));
    }

    public static int[] getNext(String s) {

        char[] chars = s.toCharArray();

        int[] next = new int[s.length()];
        //初始化next 前缀表
        //前缀表的第一个元素的肯定为0，因为只有一个元素时，没有前后缀
        next[0] = 0;

        //定义指针
        //前缀尾指针（另外还表示 当前字串的最大相同前后缀长度）
        //初始化为0,因为一开始只有一个字符，既没有前缀也没有后缀，所以取为0
        int j = 0;
        //后缀尾指针
        //初始化为1，最开始有后缀的时候即只有两个字符，这时后缀为1
        //int i = 1; 放在循环中初始化，因为要作为循环变量
        for (int i = 1; i <= s.length() - 1; i++){

            //当 chars[j] ！=" chars[i] 时，表明无法再增加最大相同前后缀的长度，但是有可能存在较小的最大相同前后缀，所以j需要减小
            //另外 j 必须大于 0 才能有回退的空间
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j - 1];
            }


            //当 chars[j] == chars[i] 时，next[i] = ++j
            if (chars[j] == chars[i]) {
                //j的值 +1
                j++;
                //记录至 i 下标 为止的字串的最大相同前后缀的长度值
                next[i] = j;
            }


        }

        return next;

    }
}
