/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);  // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy;// make a pointer pre as a marker for the node before reversing
        for(int i =0; i<m-1; i++){//将Pre指向子链表头部的前一个链表节点
            pre = pre.next;
        }
        
        ListNode start = pre.next;// make a pointer pre as a marker for the node before reversing
        ListNode then = start.next;// a pointer to a node that will be reversed
        
		//这里要画出链表图理解
		//这里实现的其实就是不断的把then交换到pre的next位置上，然后更新then，
		//start是子链表的头，所以一直保持不变
        for(int j =0; j < n-m; j++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
}