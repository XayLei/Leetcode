class ListNode{
   int val;
   ListNode next;
   ListNode(int x){
      val = x;
   }
}
/*
首先有一个你要明白的是，向右移动的K步，可能会大于链表的长度Length，于是乎你需要这么做：

1、遍历一次链表，得到链表长度N，并且将链表的尾巴连接到头结点上。 
2、从head开始走n-k%n步的位置那里断开成一个新的链表，那个就是移动后的额结果 
3、将断开的位置当做新的头结点返回，记得断开的时候别忘了把断开的位置尾巴设置为null（这也是为什么说断开）
*/
public class Solution{
  public TreeNode rotateRight(TreeNode head, int k){
    if(head == null)  return head;
    
    int length = 1;
    TreeNode p = head;
    while(p.next != null){
       length++;
       p = p.next;
    }
    
    //使链表头尾相接
    p.next = head;
    //当K大于链表长度时
    k = length - k % length;
    p = head;
    
    while(--k >= 1){
       p = p.next;
    }
    
    //确定新的头部和尾部，并将新尾部指向NULL
    head = p.next;
    p.next = null;
    //这里将P再次指向新的头部，当链表只有一个元素时，防止空指针
    p = head;
    
    return head;
  }
}
