import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 * 思路：数组是有序的（非递减顺序），意味着从左至右是按照从小到大排列的，但是考虑到负数平方后可能更大，所以排序后结果可能有差别
 *      但是注意到一点，平方后最大的数肯定在最左和最右两头，可以考虑用两个指针来指向数组的头尾，每次比较头尾的平方大小，然后将大的从右至左填入到一个新数组中，
 *      每次填入的数，其对应指针便往数组中间元素靠近，最终头尾指针相差1时就说明将结束排序
 */

public class SortedArraySquared {
    public static void main(String[] args) {
        int[] array = {-3, -2, -1, 0, 1, 3, 6};
        int[] returnNewArray = returnNewArray(array);
        System.out.println(Arrays.toString(returnNewArray));
    }

    public static int[] returnNewArray(int[] nums) {
        if (nums.length == 1) { //考虑特殊情况，原数组只有1个元素，那么就不用比,直接返回就行了
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        int head = 0;
        int last = nums.length - 1;
        int[] newArray = new int[nums.length];
        int newArrayLast = newArray.length - 1;
        while (true) {
            int headSquared = nums[head] * nums[head];
            int lastSquared = nums[last] * nums[last];
            if (headSquared > lastSquared) { //头元素平方大
                newArray[newArrayLast] = headSquared;
                head++;
                newArrayLast--;
                if (head == last) {
                    newArray[newArrayLast] = lastSquared;
                    return newArray;
                }
            } else { //尾元素平方大于或等于
                newArray[newArrayLast] = lastSquared;
                last--;
                newArrayLast--;
                if (head == last) {
                    newArray[newArrayLast] = headSquared;
                    return newArray;
                }
            }
        }
    }
}
