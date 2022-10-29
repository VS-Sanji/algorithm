import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *      示例：
 *      输入：19
 *      输出：true
 *      解释：
 *      1^2 + 9^2 = 82
 *      8^2 + 2^2 = 68
 *      6^2 + 8^2 = 100
 *      1^2 + 0^2 + 0^2 = 1
 *
 * 题目中说不是 快乐数的话，那么它求和后的值会重复出现，而快乐书不会重复出现，直到变成 1.即只需要判断是否有重复的值出现在 和集 里面，考虑使用哈希表
 */
public class IsHappy {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        //只要满足n不等于1，以及set集合中不包含此时的n（说明没有重复），那么就继续往set中存
        //退出循环了，只有两种情况，要么n=1，要么n在set中已经出现过了，即n重复了
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        //最后返回一个判断，看n是否等于1，是1即说明是快乐数，不是1，说明n是重复的，即不是快乐数
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n != 0) {
            int i = n % 10;
            res += i * i;
            n = (n - i) / 10;
        }
        return res;
    }




//    public boolean isHappy(int n) {
//        Set<Integer> record = new HashSet<>();
//        while (n != 1 && !record.contains(n)) {
//            record.add(n);
//            n = getNextNumber(n);
//        }
//        return n == 1;
//    }
//
//    private int getNextNumber(int n) {
//        int res = 0;
//        while (n > 0) {
//            int temp = n % 10;
//            res += temp * temp;
//            n = n / 10;
//        }
//        return res;
//    }
}
