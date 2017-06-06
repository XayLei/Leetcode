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
        ListNode helper = new ListNode(0); //����һ����������
        ListNode pre = helper; //ָ����������ı�ͷ
        ListNode cur = head; //����ָ��ǰ����ڵ�
        ListNode next = null; //���ڱ�����һ��������Ľڵ�
        while(cur != null){ //�����ǰ������Ľڵ㲻Ϊ�գ������ѭ��
            next = cur.next; //���ڱ�����һ��������Ľڵ�
            while(pre.next != null && pre.next.val < cur.val){
                //�������Ҫ������������Ѱ�Һ��ʵĲ���㣬ʹpre.val<cur.val<pre.next.val 
				//���pre����һ���ڵ㲻Ϊ�գ�����Pre����һ���ڵ�С�ڴ�����Ľڵ㣬��preָ�������һ��
                pre = pre.next;
            }
            //��pre����һ���ڵ㲻Ϊ�ջ�����һ���ڵ��ֵ���ڵ�ǰҪ����ڵ��ֵ����cur.val������ִ��
            //���Ƚ�Ҫ����Ľڵ�cur����һ��ָ��pre.next
            cur.next = pre.next;
            //Ȼ��pre����һ��ָ��cur��������ʵ���˽�cur���뵽pre��pre.next֮��
            pre.next = cur;
            //���Ž�curָ��next����ָ��ǰ������Ľڵ�
            cur = next;
            //��pre�ع鵽���������ͷ��
            pre = helper;
        }
        return helper.next;
    }
}