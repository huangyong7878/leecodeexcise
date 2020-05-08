package siflo.dialy;

import siflo.datastructure.ListNode;
import siflo.datastructure.ListNodeUtils;

/**
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists
 * are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value
 * 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class Daily502 {

  static int lenOfLinkedList(ListNode list) {
    int count = 0;
    while (list != null) {
      count++;
      list = list.next;
    }
    return count;
  }

  /**
   * l1 is longer than l2
   */
  static int getInteractionNodeValue(ListNode l1, ListNode l2, int d) {
    while (d > 0) {
      l1 = l1.next;
      d--;
    }
    while (l2 != null) {
      if (l1.val == l2.val) {
        return l1.val;
      }
      l2 = l2.next;
      l1 = l1.next;
    }
    return -1;
  }

  public static int solution(ListNode list1, ListNode list2) {
    int c1 = lenOfLinkedList(list1);
    int c2 = lenOfLinkedList(list2);
    if (c1 > c2) {
      return getInteractionNodeValue(list1, list2, c1 - c2);
    } else {
      return getInteractionNodeValue(list2, list1, c2 - c1);
    }
  }

  public static void main(String[] args) {
    ListNode l1 = ListNodeUtils.stringToListNode("[3,6,9,15,30]");
    ListNode l2 = ListNodeUtils.stringToListNode("[4,15,30]");
    System.out.println(solution(l2, l1));

  }
}
