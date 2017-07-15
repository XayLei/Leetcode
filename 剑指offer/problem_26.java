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
//复制复杂链表
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
    
	//将两个链表分开
    public RandomListNode spilt(RandomListNode pHead){
        RandomListNode node = pHead;
        RandomListNode clHead = null;
        RandomListNode clNode = null;
        
        if(node!=null){
            clHead = clNode = node.next; //克隆链表的头指针和节点指针
            node.next = clNode.next; //更新原链表节点的下一个节点
            node = node.next; //更新原链表中的节点指针
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