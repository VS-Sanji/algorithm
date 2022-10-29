import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 * 解释:
 * 两个元组如下:
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 *      思路：也是给定一个值，要找到符合计算法则的数，可考虑使用哈希法
 *      一共四个数组，分成AB、CD进行遍历的话时间复杂度最低，是O(n^2)
 *      如果分成A、BCD这种的话，时间复杂度就是O(n^3)了
 */
public class FourSumCount {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int total = 0;

        //获取前两个数组的subSumMap
        Map<Integer, Integer> first = getSubSumMap(nums1, nums2);

        //获取后两个数组的subSumMap
        Map<Integer, Integer> second = getSubSumMap(nums3, nums4);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            Integer key = entry.getKey();
            Integer value2 = entry.getValue();
            int gap = -key;
            if (first.containsKey(gap)) {
                Integer value1 = first.get(gap);
                total += value1 * value2;
            }
        }

        return total;

    }
    private static Map<Integer, Integer> getSubSumMap(int[] nums1, int[] nums2) {
        //为什么用map而不用set，是因为不仅要存值，还需要存该值出现的次数，几次就对应着几种方式
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int subSum = nums1[i] + nums2[j];
                if (map.containsKey(subSum)) {
                    map.put(subSum, map.get(subSum) + 1);
                } else {
                    map.put(subSum, 1);
                }
            }
        }
        return map;
    }

}
