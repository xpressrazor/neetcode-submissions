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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        return reverse(head, 0, k, len);
    }

    private ListNode reverse(ListNode head, int count, int k, int len) {
        if (k + count > len) {
            return head;
        } else {
            int curCount = 0;
            ListNode cur = head, prev = null, next = null;

            while (cur != null && curCount < k) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                curCount++;
            }

            if (next != null) {
                head.next = reverse(next, curCount + count, k, len);
            }
            
            return prev;
        }
    }

    private int getLength(ListNode head) {
        return head == null ? 0 : 1 + getLength(head.next);
    }
}
