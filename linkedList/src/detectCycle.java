import linkedListNode.circularLinkedListNode;
import linkedListNode.singlyLinkedListNode;

/**
 * 环形链表
 *      1.判断有没有环
 *      2.环的入口位置
 */
public class detectCycle {

    //自己解法，与下面标答一样的思路，但细节处理可以优化
    public circularLinkedListNode detectCycle(circularLinkedListNode head) {
        circularLinkedListNode fast = head;
        circularLinkedListNode slow = head;
        //循环条件延后到循环体中判断，注意是 ||
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            //有环
            if (fast == slow) {
                circularLinkedListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }

    }

    public singlyLinkedListNode detectCycle(singlyLinkedListNode head) {
        singlyLinkedListNode slow = head;
        singlyLinkedListNode fast = head;
        //判断条件在while()中，更简洁，注意是 &&
        //因为 fast每次都是走两步，所以把 fast 以及 fast.next 作为判断条件，不用考虑 fast.next.next,因为被下次循环判断中的 fast给攘括了
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                singlyLinkedListNode index1 = fast;
                singlyLinkedListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
