package linkedlist;

import linkedListNode.singlyLinkedListNode;

/**
 * 含有虚拟头节点的链表，其有效节点的索引从0开始，以1递增，索引不指向虚拟头节点，而是以有效节点的头节点开始
 */

public class singlyLinkedlist {

    public int size;//链表长度，即节点个数(不包括虚拟头节点)

    public singlyLinkedListNode virtualHead;//虚拟头节点

    public singlyLinkedlist() {
        size = 0;
        virtualHead = new singlyLinkedListNode();
    }

    //获取第index节点的数值
    public int get(int index) {
        //做验证，非法返回-1
        if (index < 0 || index >= size) {
            return -1;
        }

        singlyLinkedListNode temp = virtualHead.next;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }

        return temp.val;

    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    //在指定index位置插入节点
    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        //大于size，非法
        if (index > size) {
            return;
        }

        //小于0，默认插入到头部
        if (index < 0) {
            index = 0;
        }

        //size自增，表示加入了一个节点
        size++;

        //找到指定位置节点的前驱节点
        singlyLinkedListNode pre = virtualHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        singlyLinkedListNode newNode = new singlyLinkedListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;

    }


    //删除指定index的节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;
        singlyLinkedListNode pre = virtualHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
    }

}
