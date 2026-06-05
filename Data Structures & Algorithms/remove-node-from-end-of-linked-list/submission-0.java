/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        ListNode p = head;

        while (n-- > 0) {
            p = p.next;
        }

        ListNode cur = head;

        if (p == null) {
            return head.next;
        }

        while (p.next != null) {
            cur = cur.next;
            p = p.next;
        }

        cur.next = cur.next.next;

        return head;
    }

    private int getLength(ListNode head) {
        return head == null ? 0 : 1 + getLength(head.next);
    }
}
