/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode helper = new ListNode(0); //创建一个有序链表
        ListNode pre = helper; //指向有序链表的表头
        ListNode cur = head; //用于指向当前排序节点
        ListNode next = null; //用于保存下一个需排序的节点
        while(cur != null){ //如果当前需排序的节点不为空，则进入循环
            next = cur.next; //用于保存下一个待插入的节点
            while(pre.next != null && pre.next.val < cur.val){
                //这里就是要在有序链表中寻找合适的插入点，使pre.val<cur.val<pre.next.val 
				//如果pre的下一个节点不为空，并且Pre的下一个节点小于待插入的节点，则将pre指针向后移一个
                pre = pre.next;
            }
            //当pre的下一个节点不为空或是下一个节点的值大于当前要插入节点的值，即cur.val，继续执行
            //首先将要插入的节点cur的下一个指向pre.next
            cur.next = pre.next;
            //然后将pre的下一个指向cur，这样就实现了将cur插入到pre和pre.next之间
            pre.next = cur;
            //接着将cur指向next，即指向当前需排序的节点
            cur = next;
            //将pre回归到有序链表的头部
            pre = helper;
        }
        return helper.next;
    }
}