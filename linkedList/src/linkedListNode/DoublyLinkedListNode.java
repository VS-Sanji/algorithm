package linkedListNode;

public class DoublyLinkedListNode {

    public int val;

    public DoublyLinkedListNode pre;

    public DoublyLinkedListNode next;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(int val) {
        this.val = val;
    }

    public DoublyLinkedListNode(int val, DoublyLinkedListNode pre, DoublyLinkedListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
