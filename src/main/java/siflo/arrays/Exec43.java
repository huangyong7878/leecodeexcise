package siflo.arrays;

public class Exec43 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public ListNode reverseList(ListNode head) {

    if(head == null)
      return null;
    ListNode prior  = head;
    ListNode cur = head;


    while(cur!=null)
    {
      ListNode z = cur.next ;
      cur.next = prior;
      prior = cur;
      cur = z;

    }
    head.next = null;
    return prior;
  }
}
