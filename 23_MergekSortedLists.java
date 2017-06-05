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
	
	//���÷��ε�˼�룬������������Ϊ����������Ȼ���������ϲ�
	public static ListNode partion(ListNode[] lists,int start,int end){
		if(start==end) return lists[start];
		if(start < end){
			int mid = (end+start)/2;  //���������end-start�Ļ������ᱨ��ջ�������ϸ��һ�£���Ҳ�ǶԵģ����startΪ3��endΪ5����mid��Ϊ4.���õ���3+5�ٳ���2
			ListNode l1 = partion(lists,start,mid);
			ListNode l2 = partion(lists,mid+1,end);
			merge(l1,l2);  //�����˼�������ڹ鲢����
		}else{
			return null;
		}
	}
	
	//���õݹ�ķ������ϲ��������������
	public static void merge(ListNode l1,ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val){  //����Ӧ�úܺ�����
			l1.next = merge(l1.next,l2);
			return l1;
		}else{
			l2.next = merge(l1,l2.next);
			return l2;
		}
	}
}