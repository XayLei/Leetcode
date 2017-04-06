public class LinkNode{
    int val;
    LinkNode next;
    LinkNode(int x){
       val = x;
    }
}

//使用快慢指针法，快指针先于慢指针n个节点，这样，当快指针遍历到链表尾部时，慢指针也就到了需要删除的那个节点的前一个节点
 public ListNode removeNthFromEnd(ListNode head, int n){
     if(head == null)  return;
     
     ListNode fast = head;
     ListNode slow = head;
     
     for(int i = 0; i<n; i++){
        fast = fast.next;
     }
     //如果链表中只有一个元素，且n为1时，这时，由上一步可得fast为fast.next,即为null
     //所以这里吧链表的头删除就可以了
     if(fast == null){
       head = head.next;
     }
     
     while(fast != null){
        fast = fast.next;
        slow = slow.next;
     }
     //删除指定的节点
     slow.next = slow.next.next;
      return head;
 }
