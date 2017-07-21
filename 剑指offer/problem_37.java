/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//find common node in two list
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        ListNode re = null;
        int step = Math.abs(length1-length2);
        if(length1<length2){
            p1 = pHead2;
            p2 = pHead1;
        }
        for(int i=0; i<step; i++){
            p1 = p1.next;
        }
        
        while(p1!=null && p2!=null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        re = p1;
        return re;
    }
    
    public int getLength(ListNode node){
        int count = 0;
        ListNode p = node;
        while(p!=null){
            p = p.next;
            count++;
        }
        return count;
    }
}