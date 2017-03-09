/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //数据结构为链表
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null ) return null;
        int a = 0;
        return addTwoNumbers(l1,l2,a);
    }
    
    //使用递归的方法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null && carry==0) return null;
        ListNode result = new ListNode(0);
        int value = 0;
        
        if(l1!=null){
            value += l1.val;
        }
        if(l2!=null){
            value += l2.val;
        }
        value += carry;
        result.val = value % 10;
        ListNode more = addTwoNumbers(l1==null ? null : l1.next, 
                                      l2==null ? null : l2.next,
                                      value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }
    
    //使用非递归的方法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
    }
}
