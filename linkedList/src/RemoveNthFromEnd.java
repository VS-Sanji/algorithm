import linkedListNode.SinglyLinkedListNode;

/**
 * 删除链表倒数第n个节点
 */

public class RemoveNthFromEnd {


    public SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode head, int n) {
        SinglyLinkedListNode virtualNode = new SinglyLinkedListNode();
        virtualNode.next = head;
        //快慢指针
        SinglyLinkedListNode slow = virtualNode;
        SinglyLinkedListNode fast = virtualNode;

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
