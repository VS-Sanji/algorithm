import linkedListNode.singlyLinkedListNode;

/**
 * 两两交换节点
 */
public class exchangeNode {

    public singlyLinkedListNode exchangeNode(singlyLinkedListNode head) {
        singlyLinkedListNode virtualNode = new singlyLinkedListNode();
        virtualNode.next = head;

        singlyLinkedListNode cur = virtualNode;
        singlyLinkedListNode tempOne;
        singlyLinkedListNode tempTwo;

        //当同时满足cur的下一个不是空，下下一个也不是空，说明后面至少还有两个节点，继续循环进行交换
        while (cur.next != null && cur.next.next != null) {
            tempOne = cur.next;//cur指向下下个前记录cur的下个节点
            cur.next = cur.next.next;//指向下下个
            tempTwo = cur.next.next;//下下个指向上面暂存的节点前先记录其下个节点
            cur.next.next = tempOne;//交换
            cur.next.next.next = tempTwo;//连上暂存上面暂存节点
            cur = cur.next.next;//指针后移两位
        }

        return virtualNode.next;//返回头节点
    }
}
