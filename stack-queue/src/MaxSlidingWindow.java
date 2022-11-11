import com.sun.org.apache.bcel.internal.generic.PUSH;
import sun.security.util.Length;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue monotonicQueue = new MonotonicQueue();
        int len = nums.length - k + 1;
        int[] ints = new int[len];
        for (int i = k - 1; i < nums.length; i++) {

        }



        return ;
    }

    static class MonotonicQueue {
        Deque<Integer> deque;

        public MonotonicQueue() {
            this.deque = new LinkedList();
        }

        int pop() {
            return this.deque.pollFirst();
        }

        void push(int value) {
            this.deque.offerLast(value);
        }

        int maxValue() {
            return this.deque.peekFirst();
        }

    }


}
