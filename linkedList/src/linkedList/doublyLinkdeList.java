package linkedList;

import linkedListNode.doublyLinkedListNode;

/**
 * 双向链表
 */


public class doublyLinkdeList {

    //链表长
    int size;

    //虚拟头，尾节点
    doublyLinkedListNode virtualHead, virtualTail;

    public doublyLinkdeList() {
        size = 0;
        virtualHead = new doublyLinkedListNode();
        virtualTail = new doublyLinkedListNode();
        virtualHead.next = virtualTail;
        virtualTail.pre = virtualHead;
    }

    //返回第index个节点的值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        doublyLinkedListNode cur;
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

        doublyLinkedListNode cur = virtualHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        doublyLinkedListNode newNode = new doublyLinkedListNode(val);
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

        doublyLinkedListNode cur;
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
