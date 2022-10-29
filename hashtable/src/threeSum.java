import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * 示例：
 *      给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *      满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {
    public static ArrayList<int[]> threeSum(int[] nums) {
        int left;
        int right;
        ArrayList<int[]> resList = new ArrayList<>();
        Arrays.sort(nums);

        //头元素的遍历，到倒数第三个数为止，因为后面两个数得分配给 另外两个值
        for (int i = 0; i < nums.length - 2; i++) {

            //排序后，头元素大于0，或者尾元素小于0，都是不可能有解的，直接返回
            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return resList;
            }

            //如果nums[i] == nums[i - 1]，表示与前一个数相等，那么可以跳过当前这个值的循环求解过程，为什么呢?
            //因为，上一个数和当前数相等的话，那么上一个数的所有解的集合是包含当前数的所有解集合的，所以当前这个数所有的解都是重复解，故可以跳过
            //那为什么是与上一个数进行比较，而不是和后一个数进行比较呢？因为如果与后一个数比较，可能会漏掉一个解
            //比如：-1 -1 0 1 2，如果是与后一个值进行比较，就会漏掉 -1 -1 2 这个解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    //一组解
                    int[] result = new int[]{nums[i], nums[left], nums[right]};
                    resList.add(result);

                    //移动left，right，继续找其他可能的解(同时包含去重操作）
                    //如 -4 0 1 1 2 2 3 3 3， -4 1 3 是解，那么left指向第一个1，right指向最后一个3，就是解了，其他left指向的1，right指向的3，都是重复解
                    //要想找到新解，那么left要往右移动，直到指向第一个2，同理right要往左移，直到指向第二个2
                    while (right > left && nums[left] == nums[left + 1]) left++;//这里是移到最后一个1
                    while (right > left && nums[right] == nums[right - 1]) right--;//这里是移动到最前一个3

                    //移出重复值
                    left++;
                    right--;
                }
            }
        }

        return resList;
    }
}
