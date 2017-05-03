/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //这个方法类似于排列两个有序链表
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null)  return h2;
        if(h2 == null)  return h1;
        
        if(h1.val<h2.val){
            h1.next = merge(h1.next , h2);
            return h1;
        }else{
            h2.next = merge(h1 , h2.next);
            return h2;
        }
    }
    /**
	这个方法的思想：
	     由后向前排序，最开始是两两排序，然后递归为两个两个的子链表排序
	*/
    public ListNode sortList(ListNode head) {
        if(head == null)  return head;
        if(head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        
        //P1每次向前一步，P2每次向前两步
        //这步其实就是将P1指向链表的最后一个节点
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        //将链表的最后一个节点与前面部分分离
        pre.next = null;
        
        //递归处理子链表
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);
        
        //最后利用归并排序将两部分排序
        //最终排序的两个子链表，由于上一步的递归处理，两个子链表都是有序的
        return merge(h1,h2);
    }
}