
/**
 * 前提：数组为有序数组，数组中无重复元素，因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的
 * 当题目描述满足如上条件的时候，可以想一想是不是可以用二分法
 * 二分查找涉及的很多的边界条件，逻辑比较简单，如到底是 while(left < right) 还是 while(left <= right)，到底是right = middle呢，还是要right = middle - 1呢？
 * 使用二分法，需要严格定义区间，区间的定义就是不变量。要在二分查找的过程中，保持不变量，就是在while寻找中每一次边界的处理都要坚持根据区间的定义来操作，这就是循环不变量规则。
 *
 * 写二分法，区间的定义一般为两种，左闭右闭即[left, right]，或者左闭右开即[left, right)。
 * 在更新区间边界的时候，要严格遵守最初的区间定义，如左闭右闭就一直坚持到最后，以此为依据进行区间边界条件的判断
 *
 * 逻辑：（假设数组是升序排列）
 *      1.取中间值（未必是正中间），与目标值进行比较，若等于目标值，直接返回下标即可
 *      2.若大于目标值，说明目标值落在左区间，需要更新右边界，此时需要考虑右边界的问题
 *      3.若小于目标值，说明目标值落在右区间，需要更新左边界，此时需要考虑左边界的问题
 *      4.更新区间后，重复上述逻辑，继续缩小区间，直到找到目标值（返回下标），或者不存在目标值（返回-1）
 *      1-4是不断重复的逻辑，对应循环结构
 */
public class binarySearch {

    public static void main(String[] args) {

        int targetOne = 3;
        int targetTwo = 33;
        int[] nums = {1, 2, 3, 33, 123, 333};
        int indexOne = binarySearchOne(targetOne, nums);
        int indexTwo = binarySearchTwo(targetTwo, nums);
        System.out.println(indexOne);
        System.out.println(indexTwo);
    }


    //时间复杂度O(logn)
    //空间复杂度O(1)
    //左闭右闭区间
    public static int binarySearchOne(int target, int[] nums) {
        int left = 0;//起始左边界
        int right = nums.length - 1;//起始右边界
        while (left <= right) {//当左边界小于等于右边界时，持续循环判断，
            // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return -1;
            }
            int middle = left + ((right - left) >> 1); //取中间
            if (target < nums[middle]) {
                right = middle - 1;//更新右边界
            }else if (target > nums[middle]) {
                left = middle + 1;//更新左边界
            }else {
                return middle;//找到目标值
            }
        }
        return -1;//没有该目标值，返回-1
    }

    //左闭右开区间
    public static int binarySearchTwo(int target, int[] nums) {
        int left = 0;//起始左边界
        int right = nums.length;//起始右边界,右边界是开的，需要包含整个数组，所以取 nums.length
        while (left < right) {//当左边界小于右边界时，持续循环判断，不能取相等，相等时对于左闭右开区间是不合法的，说明没找到目标值
            // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return -1;
            }
            int middle = left + ((right - left) >> 1); //取中间
            if (target < nums[middle]) {
                right = middle;//更新右边界，是右开区间，所以不用减1，否则会漏掉一个有效元素
            }else if (target > nums[middle]) {
                left = middle;//更新左边界
            }else {
                return middle;//找到目标值
            }
        }
        return -1;//没有该目标值，返回-1
    }

}
