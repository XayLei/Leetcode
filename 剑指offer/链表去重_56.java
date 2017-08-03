/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead==null) return pHead;
        ListNode head = new ListNode(-1);//定义一个头结点
        head.next = pHead;
        ListNode p = pHead;
        ListNode q = head;
        while(p!=null && p.next!=null){
            if(p.val==p.next.val){
                int val = p.val;
                while(p!=null && p.val==val) //这步是去重关键
                	p=p.next;
                q.next = p;
            }else{
                q = p;
                p = p.next;
            }
        }
        return head.next;
    }
}