/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//ʹ�õݹ�ķ����ϲ�������������
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        ListNode re =null;
        if(list1.val<list2.val){
            re = list1;
            re.next = Merge(list1.next,list2);
        }else{
            re = list2;
            re.next = Merge(list1, list2.next);
        }
        return re;
    }
}