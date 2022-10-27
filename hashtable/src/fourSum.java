import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

/**
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 */
public class fourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int left;
        int right;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);



        for (int i = 0; i < nums.length - 3; i++) {

            //因为这次要找的值不是定值
            //所以做剪枝的时候不能简单的认为 排序后首元素大于target就可以直接返回了
            //如：-5，-4，-3，-2， 0， 1  target=-11，是有解 -5， -4， -3， 1的
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }

            if (i > 0 &&  nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                left = j + 1;
                right = nums.length - 1;

                while (right > left) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
//                        List<Integer> integers = new ArrayList<>();
//                        integers.add(nums[i]);
//                        integers.add(nums[j]);
//                        integers.add(nums[left]);
//                        integers.add(nums[right]);
//                        res.add(integers);
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
