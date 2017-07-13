/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k==0) return null; //当链表为空或K为0时
		ListNode p1 = head, p2 = head;
        for(int i = 0 ; i<k-1; i++){
            if(p2.next != null){ //处理链表长度小于K时的情况
                p2 = p2.next;
            }else{
                return null;
            }
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }
}