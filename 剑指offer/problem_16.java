/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//reverseHead指向翻转后的链表头部
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode reverseHead = null, p2 = head, p3 = null;
        while(p2 != null){
            ListNode pNext = p2.next;
            if(pNext == null){
                reverseHead = p2;
            }
            p2.next = p3;
            p3 = p2;
            p2 = pNext;
        }
        return reverseHead;
    }
}