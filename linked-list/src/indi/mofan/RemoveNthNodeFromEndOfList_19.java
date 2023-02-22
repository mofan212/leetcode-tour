package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/22 19:18
 */
public class RemoveNthNodeFromEndOfList_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // head = [1,2,3,4,5], n = 2 -> [1,2,3,5]
        // head = [1], n = 1 -> []
        // head = [1,2], n = 1 -> [1]
        ListNode vir = new ListNode(-1, head);
        ListNode fast = vir;
        ListNode slow = vir;

        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next == null ? null : slow.next.next;
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
