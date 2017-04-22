/**
 * 206 reverse linked list
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        //return reverseByIteration(head);
        ListNode prev = null;
        return reverseByRecursion(prev, head);
        
    }
    // iteration version
    private ListNode reverseByIteration(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null) {
            curr.next = last;
            last = curr;
            curr = next;
            next = next.next;
        }
        curr.next = last;
        return curr;
    }
    
    // recursion version
    private ListNode reverseByRecursion(ListNode prev, ListNode head) {
        ListNode next = head.next;
        head.next = prev;
        // base case
        if (next == null) {
            return head;
        }
        // recursion case
        return reverseByRecursion(head, next);
    }
}