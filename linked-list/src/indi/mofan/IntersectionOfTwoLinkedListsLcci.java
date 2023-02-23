package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/23 23:40
 * @link https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class IntersectionOfTwoLinkedListsLcci {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
