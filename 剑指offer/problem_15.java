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
        if(head == null || k==0) return null; //������Ϊ�ջ�KΪ0ʱ
		ListNode p1 = head, p2 = head;
        for(int i = 0 ; i<k-1; i++){
            if(p2.next != null){ //����������С��Kʱ�����
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