package siflo.dialy;

import siflo.datastructure.ListNode;
import siflo.datastructure.ListNodeUtils;

/**
 * Given a singly linked list and an integer k, remove the kth last element from the list. k is
 * guaranteed to be smaller than the length of the list.
 *
 * The list is very long, so making more than one pass is prohibitively expensive.
 *
 * Do this in constant space and in one pass.
 */
public class Daily508 {

  public static void printLastKElement(ListNode node, int k) {
    ListNode head = node;

    ListNode[] a = new ListNode[k];
    int count = 0;
    while (node != null) {
      if (count == k) {
        count = 0;
      }
      if (node.next == null) {
        //end
        if (count == k - 1) {
          if (a[0] == head) {
            head = head.next;

          } else {
            a[1].next = a[0].next;
          }
          a[0].next = null;
        } else {
          a[count].next = a[count + 1].next;
          a[count + 1].next = null;
        }
        return;
      } else {
        a[count] = node;
        count++;
        node = node.next;
      }
    }

  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeUtils.stringToListNode("[1,2,3,4,5]");
     printLastKElement(listNode, 2);

  }

}
