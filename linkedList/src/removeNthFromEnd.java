import linkedListNode.singlyLinkedListNode;

/**
 * 删除链表倒数第n个节点
 */

public class removeNthFromEnd {


    public singlyLinkedListNode removeNthFromEnd(singlyLinkedListNode head, int n) {
        singlyLinkedListNode virtualNode = new singlyLinkedListNode();
        virtualNode.next = head;
        singlyLinkedListNode slow = virtualNode;
        singlyLinkedListNode fast = virtualNode;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return virtualNode.next;
    }
}
