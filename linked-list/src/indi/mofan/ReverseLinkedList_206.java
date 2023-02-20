package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/20 10:07
 */
public class ReverseLinkedList_206 {
    /*
     * 要点：
     * 为防止原始链表断裂，需要引入 temp 局部变量保存当前节点指向的下一个节点
     */

    public ListNode reverseList(ListNode head) {
        // 1 -> 2 -> 3 -> 4 -> 5
        // 5 -> 4 -> 3 -> 2 -> 1
        ListNode newHead = head;
        ListNode newNext = null;
        ListNode temp;
        while (newHead != null) {
            temp = newHead.next;
            newHead.next = newNext;
            newNext = newHead;
            newHead = temp;
        }
        return newNext;
    }

    public ListNode reverseListRecursively(ListNode head) {
        // 1 -> 2 -> 3 -> 4 -> 5
        // 5 -> 4 -> 3 -> 2 -> 1
        return recursion(null, head);
    }

    public ListNode recursion(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return recursion(cur, temp);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
