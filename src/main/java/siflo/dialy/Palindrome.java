package siflo.dialy;

/**
 * 要求O(n) 和 常量存储空间 时间O(n)空间O(1) 判断一个链表是否为回文链表： 例子1： 1->2->null      false 例子2： 1->2->2->1->null
 * true
 */
public class Palindrome {

  class LinkNode {

    int val;
    LinkNode next;
  }

  private LinkNode reserseInLoop(int start, int len, LinkNode head) {
    return null;
  }

  private int getLenOfLinkNodeList(LinkNode head) {
    return -1;
  }

  private boolean compareTwoNodeList(LinkNode longer, LinkNode halfLink) {
    return true;
  }

  public boolean isPalindrome(LinkNode head) {
    //first , we need to know its len
    int len = getLenOfLinkNodeList(head);
    //
    LinkNode newNode = null;
    if (len % 2 == 0) {
      //we reverse from len/2 to end
      newNode = reserseInLoop(len / 2, len / 2, head);
    } else {
      //
      newNode = reserseInLoop(len / 2 + 1, len / 2, head);
    }
    return compareTwoNodeList(head, newNode);
  }
}
