package linkedListNode;

public class singlyLinkedListNode {

    //值
    public int val;

    //下个节点
    public singlyLinkedListNode next;

    //无参构造
    public singlyLinkedListNode() {
    }

    //有参构造（1个参数）
    public singlyLinkedListNode(int val) {
        this.val = val;
    }

    //有参构造（两个参数）
    public singlyLinkedListNode(int val, singlyLinkedListNode next) {
        this.val = val;
        this.next = next;
    }

}
