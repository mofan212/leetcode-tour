package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/21 14:47
 * @link https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        // 1 -> 2 -> 3 -> 4
        // 2 -> 1 -> 4 -> 3
        ListNode vir = new ListNode(-1, head);
        ListNode cur = vir;
        ListNode first;
        ListNode second;
        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = cur.next.next;

            cur.next = second;
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;

            cur = first;
        }
        return vir.next;
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
