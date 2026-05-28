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
        if(head==null || head.next==null || k==1)
                return head;
        // 1. FIRST CHECK: See if there are at least k nodes available to reverse
        ListNode check = head;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }
        
        // If we don't have k nodes left, leave this group as it is and return head
        if (count < k) {
            return head;
        }

        // 2. REVERSE: If we made it here, we have k nodes. Reverse them.
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        count = 0;
        
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        // 3. RECURSE: 'next' now points to the head of the remaining list.
        // 'head' is now the tail of our freshly reversed group.
        if (next != null) {
            ListNode restHead = reverseKGroup(next, k);
            head.next = restHead; // Connect our tail to the head of the rest of the list
        }
        
        // 'prev' is the new head of this reversed k-group
        return prev;
    }
}
