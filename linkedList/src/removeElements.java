import linkedListNode.SinglyLinkedListNode;

/**
 * 那么因为单链表的特殊性，只能指向下一个节点，刚刚删除的是链表的中第二个，和第四个节点，那么如果删除的是头结点又该怎么办呢？
 * 这里就涉及如下链表操作的两种方式：
 *      直接使用原来的链表来进行删除操作。这种方式下，对于链表头节点的操作与非头节点的操作是有差别的，因为头节点没有上一个节点，需要单独考虑
 *      设置一个虚拟头结点在进行删除操作。这种方式下，头节点与非头节点操作相同，具有统一性
 */
public class RemoveElements {
    public static void main(String[] args) {

    }

    public static SinglyLinkedListNode rmElements(SinglyLinkedListNode head, int target) {
        SinglyLinkedListNode virtualNode = new SinglyLinkedListNode();
        virtualNode.next = head;
        SinglyLinkedListNode temp = virtualNode;
        while (temp.next != null) {
            if (temp.next.val == target) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return virtualNode.next;
    }

}
