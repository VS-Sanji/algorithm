import linkedListNode.singlyLinkedListNode;

/**
 * 删除链表倒数第n个节点
 */

public class removeNthFromEnd {


    public singlyLinkedListNode removeNthFromEnd(singlyLinkedListNode head, int n) {
        singlyLinkedListNode virtualNode = new singlyLinkedListNode();
        virtualNode.next = head;
        //快慢指针
        singlyLinkedListNode slow = virtualNode;
        singlyLinkedListNode fast = virtualNode;

        //快指针先向前移动n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        //快指针未指向最后的null之前，快慢指针同时后移
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //慢指针最终指向要删除的节点的前驱节点
        slow.next = slow.next.next;
        return virtualNode.next;
    }
}
