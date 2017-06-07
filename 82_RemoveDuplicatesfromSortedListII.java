/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(Integer.MIN_VALUE);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){  //这里的循环判断使cur最终指向重复元素子链的尾部
                cur=cur.next;
            }
            if(pre.next==cur){ //如果pre的下一个节点是cur，则说明cur指向的元素没有重复
                pre=pre.next;
            }
            else{
                pre.next=cur.next; 
				//如果pre的下一个节点不是cur，说明cur指向的是重复元素，
				//那么pre的下一个节点指向重复元素尾部的下一个节点，这样就实现了在链表中删除重复元素子链。
            }
            cur=cur.next; //将cur指向下一个节点，进行下一次的重复元素查找
        }
        return FakeHead.next;
    }
}