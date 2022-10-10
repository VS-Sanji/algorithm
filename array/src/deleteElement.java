
/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：利用两个指针来操作同一个数组，分别为快指针和慢指针，快指针一直往前读数组的元素，当读取到的值与所给值不等时，填入慢指针指向的空间。
 *      快指针用来读元素
 *      慢指针用来记录移除后数组的值
 */

public class deleteElement {
    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3, 3, 44, 4, 5, 3};
        int val = 3;
        int length = newArrayLength(oldArray, val);
        System.out.println(length);

    }

    //时间复杂度O(n)
    //空间复杂度O(1)
    public static int newArrayLength(int[] nums, int val){
        int fast;
        int slow = 0;
        for (fast = 0; fast <= nums.length - 1; fast++) {
            if (nums[fast] == val) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }


}
