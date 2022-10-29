package linkedListNode;

public class SinglyLinkedListNode {

    //值
    public int val;

    //下个节点
    public SinglyLinkedListNode next;

    //无参构造
    public SinglyLinkedListNode() {
    }

    //有参构造（1个参数）
    public SinglyLinkedListNode(int val) {
        this.val = val;
    }

    //有参构造（两个参数）
    public SinglyLinkedListNode(int val, SinglyLinkedListNode next) {
        this.val = val;
        this.next = next;
    }

}
