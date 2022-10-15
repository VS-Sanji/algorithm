package linkedListNode;

public class circularLinkedListNode {

    public int val;

    public circularLinkedListNode next;

    public circularLinkedListNode() {
    }

    public circularLinkedListNode(int val) {
        this.val = val;
    }

    public circularLinkedListNode(int val, circularLinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}
