import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 *
 *      思路：强调一下 什么时候使用哈希法，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
 *      本题呢，我就需要一个集合来存放我们遍历过的元素，然后在遍历数组的时候去询问这个集合，某元素是否遍历过，也就是 是否出现在这个集合。
 *
 * 可以这么做:给定一个数，作为目标值，我们遍历数组，每遍历一个就看一下它所需要的另外一个数在不在集合中，如果不在，那么就把这个数存到集合中，继续往后遍历做判断，一直到结束
 *          如果期间发现当前数所需的数在集合中，说明两者之和就为目标值，返回对应下标
 *          另外，不仅需要存这个数，还需要存它在数组中的下标，所以考虑使用map集合
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((target - nums[i]))) {
                res = new int[]{map.get(target - nums[i]), i};
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}

