import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue monotonicQueue = new MonotonicQueue();
        int len = nums.length - k + 1;
        int[] res = new int[len];

        //先将前k个元素存入队列（未必都能放进去，但保证单调队列队首是最大值，能够满足最终结果)
        for (int i = 0; i < k; i++) {
            monotonicQueue.push(nums[i]);
        }

        //初始化结果数组的值
        int index = 0;
        res[index++] = monotonicQueue.maxValue();


        //滑动窗口以1的增长向后移动，每移动一步，单调队列push一下，pop一下，并取此时的最大值存入结果数组
        for (int i = k; i < nums.length; i++) {
            monotonicQueue.push(nums[i]);
            monotonicQueue.pop(nums[i - k]);
            res[index++] = monotonicQueue.maxValue();
        }

        return res;
    }

    //用deque模拟的单调队列
    //此单调队列的队头总是维护滑动窗口中的最大值
    static class MonotonicQueue {
        Deque<Integer> deque;

        public MonotonicQueue() {
            this.deque = new LinkedList();
        }

        //单调队列的pop方法，当滑动窗口移动时，所移出的元素正好是最大值时，单调队列需要pop头部元素，表示不再维护这个值
        void pop(int out) {
            //不是while，而是if，因为是严格单调的单调队列，最大值就一个
            if (!deque.isEmpty() && out == deque.peekFirst()) {
                deque.pop();
            }
        }

        //单调队列的push方法
        //每次push
        void push(int newIn) {

            //可以存在 4，3，3 这种单调，但不能出现 4，3，4，这种，前者的3可能接连作为最大值，只存入一个的话可能出错
            //如5，4， 3， 3， 1 ，1，1这种数组，当窗口长为3时，取 【3，3，1】最大为3，【3，1，1】最大也为3，有两个最大的值为3，所以不能将之前存入的3移除
            while (!deque.isEmpty() && deque.peekLast() < newIn) { //这里 必须是 <,而不是 <=
                deque.removeLast();
            }
            this.deque.offerLast(newIn);
        }

        int maxValue() {
            return deque.peekFirst();
        }

    }


}
