/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) return head.next;
        int i = 0;
        ListNode nth = null;
        ListNode cur = head;
        // 0->1->2->3->4
        //       3  2  1
        while (cur.next != null) {
            cur = cur.next;
            i++;
            if (nth != null) {
                nth = nth.next;
            }
            if (i == n) {
                nth = head;
            }
            
        }
        if (nth != null && nth!= head) {
            nth.next = nth.next.next;
        }
        if (nth == head) {
            head.next = head.next.next;
        }
        if (nth == null) {
            head = head.next;
        }
        return head;
    }
}