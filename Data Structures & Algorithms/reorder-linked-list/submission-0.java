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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode nextToMid = slow.next;
        slow.next = null;
        ListNode rev = reverse(nextToMid);

        ListNode l = new ListNode(-1);
        ListNode h = l;

        ListNode cur = head;

        while (cur != null || rev != null) {
            if (cur != null) {
                l.next = cur;
                cur = cur.next;
                l = l.next;
            }

            if (rev != null) {
                l.next = rev;
                rev = rev.next;
                l = l.next;
            }
        }        
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, next, cur = node;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
