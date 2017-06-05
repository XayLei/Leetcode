/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }
	
	//采用分治的思想，将链表数组拆分为单个的链表，然后再两两合并
	public static ListNode partion(ListNode[] lists,int start,int end){
		if(start==end) return lists[start];
		if(start < end){
			int mid = (end+start)/2;  //这里如果是end-start的话，将会报错，栈溢出。仔细想一下，加也是对的，如果start为3，end为5，则mid就为4.正好等于3+5再除以2
			ListNode l1 = partion(lists,start,mid);
			ListNode l2 = partion(lists,mid+1,end);
			merge(l1,l2);  //这里的思想类似于归并排序
		}else{
			return null;
		}
	}
	
	//采用递归的方法，合并两个有序的链表
	public static void merge(ListNode l1,ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val){  //这里应该很好理解的
			l1.next = merge(l1.next,l2);
			return l1;
		}else{
			l2.next = merge(l1,l2.next);
			return l2;
		}
	}
}