import javafx.scene.shape.VLineTo;
import sun.security.provider.Sun;

import java.util.Base64;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 * 示例：输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 思路：
 *      1.暴力解法，利用两个for循环，外层for遍历数组，表示以各个元素为子数组起始元素的情况
 *          内层for从外层for起始元素开始往后取值，表示子数组的终止元素，并计算其和，其中首次满足条件的即是最小长度子数组，记录其长度，遍历完成后返回最小长度
 *          时间复杂度：O(n^2)
 *          空间复杂度：O(1)
 *
 *      2.滑动窗口：所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
 *          在暴力解法中，是一个for循环滑动窗口的起始位置，一个for循环为滑动窗口的终止位置，用两个for循环 完成了一个不断搜索区间的过程。
 *          那么滑动窗口如何用一个for循环来完成这个操作呢。
 *          首先要思考 如果用一个for循环，那么应该表示 滑动窗口的起始位置，还是终止位置。
 *          如果只用一个for循环来表示 滑动窗口的起始位置，那么如何遍历剩下的终止位置？
 *          此时难免再次陷入 暴力解法的怪圈。
 *          所以 只用一个for循环，那么这个循环的索引，一定是表示 滑动窗口的终止位置。
 *
 *          用一个for来控制终止位置，数组的每一个元素都需要涵盖，需要遍历
 *          起始位置从数组下标0开始，当终止元素向后移动的过程中一旦满足了条件，即可停止，此时的子数组长度即为以该起始元素打头的所有子数组中长度最小的
 *          然后向前移动起始元素，进行判断，若不满足条件，则继续移动终止元素
 *          若仍然满足条件，则此时也是最小长度子数组
 *          依次进行，直到遍历完成
 */

public class minLengthSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 2, 7};
        int val = 9;
        int minLength = minLength(nums, val);
        System.out.println(minLength);
    }

    public static int minLength(int[] nums, int val){
        int begin = 0;
        int sum = 0;
        int length = 0;
        int minLength = 0;
        for (int last = 0; last < nums.length; last++) {
            sum += nums[last];//进入循环首先加上尾部元素
            if (sum >= val) {//判断是否大于等于目标值，是则需要操作起始下标右移，否则直接进入下次循环
                if (begin == 0) {//起始下标为0，初始化minLength
                    minLength = last - begin + 1;
                }
                while (true) {//找到以该last为尾元素的最短子数组
                    if ((sum -= nums[begin]) >= val) {//去除此时的首元素，判断是否仍然大于等于目标值
                        begin++;//首元素下标右移
                    }else {
                        break;
                    }
                }
                length = last - begin + 1;//获取以该last为尾元素的最短子数组的长度
                begin++;//首部继续右移
                if (minLength > length) {//判断最终的minLength是否需要更新
                    minLength = length;
                }
            }
        }
        return minLength;
    }
}
