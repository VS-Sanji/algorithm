import linkedListNode.SinglyLinkedListNode;

/**
 * 反转链表
 */
public class ReverseList {


    //双指针解法
    public SinglyLinkedListNode reverseList(SinglyLinkedListNode head) {

        //前置指针，cur的前一个节点
        SinglyLinkedListNode pre = null;
        //当前指针，当前所指节点
        SinglyLinkedListNode cur = head;
        //临时指针，用来暂存cur的下一个节点
        SinglyLinkedListNode temp;

        //根据对称性，pre指向null开始，那么反转完成时，cur也应当指向null，因为完全的两次反转就能恢复原来的状态
        while (cur != null) {
            //temp需要在cur.next指向pre前记录下cur.next的值，以便cur的后移操作
            temp = cur.next;
            cur.next = pre;
            //pre需要先向前移动，否则当cur移动了，就找不到cur的值了，pre就无法移动了
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    //递归解法
    public SinglyLinkedListNode reverseListRecursion(SinglyLinkedListNode cur, SinglyLinkedListNode pre) {
        if (cur == null) {
            return pre;
        }

        SinglyLinkedListNode temp;
        temp = cur.next;
        cur.next = pre;

        return reverseListRecursion(temp, cur);
    }
}
