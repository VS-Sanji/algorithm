package linkedList;

import linkedListNode.DoublyLinkedListNode;

/**
 * 双向链表
 */


public class DoublyLinkdeList {

    //链表长
    int size;

    //虚拟头，尾节点
    DoublyLinkedListNode virtualHead, virtualTail;

    public DoublyLinkdeList() {
        size = 0;
        virtualHead = new DoublyLinkedListNode();
        virtualTail = new DoublyLinkedListNode();
        virtualHead.next = virtualTail;
        virtualTail.pre = virtualHead;
    }

    //返回第index个节点的值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        DoublyLinkedListNode cur;
        if (index > size >> 1) {//判断靠头近还是靠尾近
            cur = virtualTail;
            for (int i = size - 1; i >= index; i--) {
                cur = cur.pre;
            }
        } else {
            cur = virtualHead;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        }

        return cur.val;
    }

    //往头部插入节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //往尾部插入节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    //往index处插入节点
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        size++;

        DoublyLinkedListNode cur = virtualHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        newNode.pre = cur.pre;
        newNode.next = cur.pre.next;
        cur.pre.next = newNode;
        cur.pre = newNode;
    }

    //删除索引为index的节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;

        DoublyLinkedListNode cur;
        if (index > size >> 1) {
            cur = virtualTail;
            for (int i = size; i >= index; i--) {
                cur = cur.pre;
            }
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        } else {
            cur = virtualHead;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
    }


}
