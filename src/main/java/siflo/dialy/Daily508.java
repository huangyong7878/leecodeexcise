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

  public static int printLastKElement(ListNode node, int k) {
    int[] a = new int[k];
    int count = 0;
    while (node != null) {
      if (count == k) {
        count = 0;
      }
      a[count] = node.val;
      count++;
      node = node.next;
    }
    if (count == k) {
      return a[0];
    } else {
      return a[count];
    }

  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeUtils.stringToListNode("[1,2,3,4,5,6,7]");
    int a = printLastKElement(listNode, 6);
    System.out.println(a);
  }

}
