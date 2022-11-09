import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class MyQueue {

    Stack inStack;
    Stack outStack;

    public MyQueue() {
        this.inStack = new Stack();
        this.outStack = new Stack();
    }



    private void push(int data) {
        inStack.push(data);
    }

    private int pop() {
        if (!outStack.isEmpty()) {
            return ((int) outStack.pop());
        } else {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return ((int) outStack.pop());
        }
    }

    private int peek() {
        int peek = this.pop();
        outStack.push(peek);
        return peek;
    }

    private boolean empty() {
        if (inStack.size() == 0 && outStack.size() == 0) {
            return true;
        }
        return false;
    }
}
