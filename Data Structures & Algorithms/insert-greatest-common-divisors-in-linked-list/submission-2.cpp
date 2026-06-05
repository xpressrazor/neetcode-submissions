/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
private:
    int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode* cur = head;

        while (cur->next != nullptr) {
            ListNode* next = cur->next;
            ListNode* g = new ListNode(gcd(cur->val, next->val));
            g->next = next;
            cur->next = g;
            cur = next;
        }

        return head;
    }
};