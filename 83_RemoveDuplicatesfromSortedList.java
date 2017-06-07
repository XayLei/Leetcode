/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	//我的解决方法，好长
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode help = new ListNode(Integer.MIN_VALUE);
        help.next = head;
        ListNode pre = help;
        ListNode later = pre.next;
        while(later != null){
            if(pre.val == later.val){
                pre.next = later.next;
                later.next = null;
                later = pre.next;
            }else{
                pre = later;
                later = pre.next;
            }
        }
        return help.next;
    }
	
	//递归方法
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}