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
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // it is slow
    }
    public void reorderList(ListNode head) {
        // step 1 - find mid

        ListNode mid = getMid(head);

        // step 2 - 2nd half revrse 
        ListNode prev = null;
        ListNode curr = mid.next;
        mid.next = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode LH = head;
        ListNode RH = prev;

        // step 3 - alternate merge

        ListNode nextL, nextR;
        while(LH != null && RH != null){
            // zig - zag  form
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;

            RH = nextR;
            LH = nextL;

        }
    }
}