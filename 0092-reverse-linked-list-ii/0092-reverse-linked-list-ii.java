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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Step 1: Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: prev ko left se ek position pehle le jao
        ListNode prev = dummy;

        for(int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: curr = left node
        ListNode curr = prev.next;

        // Step 4: reverse
        for(int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;

            next.next = prev.next;

            prev.next = next;
        }

        return dummy.next;
    }
}