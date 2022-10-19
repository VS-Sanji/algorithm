import linkedListNode.singlyLinkedListNode;

/**
 * 找出两链表相交的节点
 */
public class getIntersectionNode {
    public singlyLinkedListNode getIntersetionNode(singlyLinkedListNode headA, singlyLinkedListNode headB) {
        int countA = 1;
        int countB = 1;
        singlyLinkedListNode temp;
        temp = headA;
        while (temp.next != null) {
            countA++;
            temp = temp.next;
        }

        temp = headB;
        while (temp.next != null) {
            countB++;
            temp = temp.next;
        }

        int max = Math.max(countA, countB);
        int min = Math.min(countA, countB);
        if (countA > countB) {
            for (int i = 0; i < (max - min); i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < (max - min); i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        if (headA != headB && headA.next == null) {
            return null;
        } else {
            return headA;
        }
    }
}
