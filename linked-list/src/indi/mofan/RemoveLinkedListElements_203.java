package indi.mofan;

import java.util.StringJoiner;

/**
 * @author mofan
 * @date 2023/2/13 19:00
 * @link https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        // head = [1,2,6,3,4,5,6], val = 6 ==> [1,2,3,4,5]
        ListNode node = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(
                                                5,
                                                new ListNode(6)
                                        )
                                )
                        )
                )
        );
        System.out.println(removeElements(node, 6));
        // head = [], val = 1 ==> [0]
        node = new ListNode();
        System.out.println(removeElements(node, 1));
        // head = [7,7,7,7], val = 7 ==> null
        node = new ListNode(
                7,
                new ListNode(
                        7,
                        new ListNode(7)
                )
        );
        System.out.println(removeElements(node, 7));
    }

    public static ListNode removeElements(ListNode head, int val) {
        // 设置虚拟节点 -1
        ListNode node = new ListNode(-1, head);
        ListNode curr = node;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return node.next;
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

        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(",", "[", "]");
            joiner.add(String.valueOf(val));
            ListNode curr = this;
            while (curr.next != null) {
                joiner.add(String.valueOf(curr.next.val));
                curr = curr.next;
            }
            return joiner.toString();
        }
    }
}
