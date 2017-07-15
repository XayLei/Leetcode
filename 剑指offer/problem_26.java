/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
//���Ƹ�������
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        clone(pHead);
        random(pHead);
        return spilt(pHead);
    }
    public void clone(RandomListNode pHead){
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode cl = new RandomListNode(node.label);
            cl.next = node.next;
            cl.random = null;
            
            node.next = cl;
            node = cl.next;
        }
    }
    
    public void random(RandomListNode pHead){
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode clNode = node.next;
            if(node.random != null){
                clNode.random = node.random.next;
            }
            node = clNode.next;
        }
    }
    
	//����������ֿ�
    public RandomListNode spilt(RandomListNode pHead){
        RandomListNode node = pHead;
        RandomListNode clHead = null;
        RandomListNode clNode = null;
        
        if(node!=null){
            clHead = clNode = node.next; //��¡�����ͷָ��ͽڵ�ָ��
            node.next = clNode.next; //����ԭ����ڵ����һ���ڵ�
            node = node.next; //����ԭ�����еĽڵ�ָ��
        }
        while(node != null){
            clNode.next = node.next;
            clNode = clNode.next;
            node.next = clNode.next;
            node = node.next;
        }
        
        return clHead;
    }
}