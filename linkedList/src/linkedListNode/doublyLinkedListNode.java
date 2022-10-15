package linkedListNode;

public class doublyLinkedListNode {

    public int val;

    public doublyLinkedListNode pre;

    public doublyLinkedListNode next;

    public doublyLinkedListNode() {
    }

    public doublyLinkedListNode(int val) {
        this.val = val;
    }

    public doublyLinkedListNode(int val, doublyLinkedListNode pre, doublyLinkedListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
