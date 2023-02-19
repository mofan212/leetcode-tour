package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/19 15:16
 * @link https://leetcode.cn/problems/design-linked-list/
 */
public class DesignLinkedList_707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        // 1 -> 2 -> 3
        linkedList.addAtIndex(1, 2);
        assert 2 == linkedList.get(1);
        // 1 -> 3
        linkedList.deleteAtIndex(1);
        assert 3 == linkedList.get(1);

        // 1 -> null
        linkedList.deleteAtIndex(1);
        // []
        linkedList.deleteAtIndex(0);
        assert 0 == linkedList.size;

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        // 1 -> 2 -> 3
        linkedList.addAtIndex(1, 2);
        assert 2 == linkedList.get(1);
        // 1 -> 3
        linkedList.deleteAtIndex(1);
        assert 3 == linkedList.get(1);
        assert -1 == linkedList.get(3);
        // 1 -> 3
        linkedList.deleteAtIndex(3);
        // 3 -> null
        linkedList.deleteAtIndex(0);
        assert 3 == linkedList.get(0);
        // []
        linkedList.deleteAtIndex(0);
        assert -1 == linkedList.get(0);
    }

    static class MyLinkedList {
        private int size;
        private LinkedListNode head;

        public MyLinkedList() {
            // 0 <= val <= 1000
            this.head = new LinkedListNode(-1);
            this.size = 0;
        }

        /**
         * 获取第 index 个节点的值，索引无效返回 -1
         */
        public int get(int index) {
            if (index < 0 || index >= this.size) {
                return -1;
            }
            LinkedListNode result = head;
            for (int i = 0; i <= index; i++) {
                result = result.next;
            }
            return result.val;
        }

        /**
         * 添加一个头结点
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * 添加一个尾节点
         */
        public void addAtTail(int val) {
            addAtIndex(this.size, val);
        }

        /**
         * 在 index 位置前添加值为 val 的节点
         * 1. 如果 index 等于链表长度，添加到末尾
         * 2. 如果 index 大于链表长度，不添加节点
         * 3. 如果 index 小于 0，在头部添加节点
         */
        public void addAtIndex(int index, int val) {
            if (index > this.size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            LinkedListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            LinkedListNode newNode = new LinkedListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;
            this.size++;
        }

        /**
         * 删除 index 位置的节点
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= this.size) {
                return;
            }
            this.size--;
            if (index == 0) {
                head = head.next;
                // 删除头结点后，立即返回
                return;
            }
            LinkedListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }

        static class LinkedListNode {
            private final int val;
            private LinkedListNode next;

            public LinkedListNode(int val) {
                this.val = val;
            }
        }
    }
}
