package linkedListNode;

public class CircularLinkedListNode {

    public int val;

    public CircularLinkedListNode next;

    public CircularLinkedListNode() {
    }

    public CircularLinkedListNode(int val) {
        this.val = val;
    }

    public CircularLinkedListNode(int val, CircularLinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}
