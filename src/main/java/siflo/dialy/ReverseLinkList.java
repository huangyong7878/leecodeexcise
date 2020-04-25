package siflo.dialy;

public class ReverseLinkList {

  static class Node {

    int val;
    Node next;

  }

//  public Node helper(Node cur,Node prev) {
//    if(cur==null)
//      return prev;
//    if (cur.next == null) {
//      return cur;
//    }
//    Node next = helper(cur.next,cur);
//    if(next!=null){
//      cur.next = prev;
//      prev.next = null;
//    }
//    return cur;
//  }

  public static Node reverse(Node head) {
    if(head==null)
      return head;
    if (head.next == null)
      return head;
    Node newNode = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return  newNode;
  }

  public static void main(String[] args) {
    Node node3 = new Node();
    node3.val =3;

    Node node2 = new Node();
    node2.val = 2;

    node2.next = node3;

    Node node1 = new Node();
    node1.val = 1;

    node1.next = node2;

    Node head = new Node();
    head.val = 0;
    head.next = node1;
    Node newHead = reverse(head);
    while(newHead!=null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

  }
}
