package siflo.dialy;

import sun.misc.Unsafe;

/**
 * An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding
 * next and prev fields, it holds a field named both, which is an XOR of the next node and the
 * previous node. Implement an XOR linked list; it has an add(element) which adds the element to the
 * end, and a get(index) which returns the node at index.
 *
 * If using a language that has no pointers (such as Python), you can assume you have access to
 * get_pointer and dereference_pointer functions that converts between nodes and memory addresses.
 */
public class Daily418 {

  public static class XORNode {

    int both;
    int value;
  }

  public static class XORLinkedList {

    private XORNode head;
    private XORNode last;
    XORNode[] nodes = new XORNode[1024];
    int cursor = 0;
    int getPoint(XORNode o) {
      for(int i=0;i<nodes.length&& nodes[i]!=null;i++)
        if(nodes[i]==o)
          return i;
      return -1;

    }

    XORNode getNodeByPtr(int nextPtrAddress) {
      return nodes[nextPtrAddress];
    }

    public void add(int value)  {
      XORNode node = new XORNode();
      node.value = value;
      nodes[cursor++] = node;
      if (head == null) {
        head = node;
        node.both = getPoint(node);
      } else {
        int prev = last.both;
        int cu =  getPoint(node);
        last.both = prev ^ cu;
        node.both = getPoint(last)^cu;
      }

      last = node;
    }

    public XORNode get(int index) {
      XORNode p = head;
      int z = 0;
      int preNodAddress = 0;
      while (p != null && z != index) {
        int currtNodeAddress = getPoint(p);
        int nextPtrAddress = p.both ^ preNodAddress^currtNodeAddress;
        if (nextPtrAddress != 0) {
          p = getNodeByPtr(nextPtrAddress);
          preNodAddress = currtNodeAddress;
          z++;
        } else {
          return null;
        }
      }
      return p;
    }
  }

  public static void main(String[] args) {
    XORLinkedList list = new XORLinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    XORNode node = list.get(3);
    System.out.println(node.value);
  }
}
