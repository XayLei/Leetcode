/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //�����������������������������
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null)  return h2;
        if(h2 == null)  return h1;
        
        if(h1.val<h2.val){
            h1.next = merge(h1.next , h2);
            return h1;
        }else{
            h2.next = merge(h1 , h2.next);
            return h2;
        }
    }
    /**
	���������˼�룺
	     �ɺ���ǰ�����ʼ����������Ȼ��ݹ�Ϊ��������������������
	*/
    public ListNode sortList(ListNode head) {
        if(head == null)  return head;
        if(head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        
        //P1ÿ����ǰһ����P2ÿ����ǰ����
        //�ⲽ��ʵ���ǽ�P1ָ����������һ���ڵ�
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        //����������һ���ڵ���ǰ�沿�ַ���
        pre.next = null;
        
        //�ݹ鴦��������
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);
        
        //������ù鲢��������������
        //�������������������������һ���ĵݹ鴦�������������������
        return merge(h1,h2);
    }
}