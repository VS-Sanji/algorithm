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

        //如果有交点，将较长的链表多出的部分不予考虑，因为一定不会是这部分节点，所以将指针后移至较短链表的头节点平行处
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

        //比较两个指针指向的节点是否相同，相同的即为交点
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
