package siflo.dialy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinTreeManipulator {

  static class BinTreeNode {

    private String value;
    BinTreeNode left, right;

    BinTreeNode(String value, BinTreeNode left, BinTreeNode right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }

  }

  void preOrderTravel(BinTreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append("(" + root.value);
    if (root.left != null) {
      sb.append(",");
    }
    preOrderTravel(root.left, sb);
    if (root.right != null) {
      sb.append(",");
    }
    preOrderTravel(root.right, sb);
    sb.append(")");
    return;
  }

  //先序遍历
  public String serialize(BinTreeNode root) {
    StringBuilder sb = new StringBuilder();
    preOrderTravel(root, sb);
    return sb.toString();
  }

  static Map<Character, String> statusMap = new HashMap<>();

  static {
    statusMap.put('(', "VS");
//    statusMap.put('')
  }

  private BinTreeNode parseNode(char[] chars) {
    Stack<BinTreeNode> stack = new Stack<>();

    StringBuilder sb = new StringBuilder();
    int commaIndex = -1, bracketIndex;
    BinTreeNode binTreeNode = null;
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == '(') {
        commaIndex = i;

      }
      if (c == ',') {
        if (commaIndex != -1) {
          String value = new String(chars, commaIndex + 1, i-commaIndex-1);
          binTreeNode = new BinTreeNode(value, null, null);
          stack.push(binTreeNode);
          commaIndex = -1;
        }
      }
      if (c == ')') {
        if (commaIndex != -1) {
          String value = new String(chars, commaIndex + 1, i-commaIndex-1);
          binTreeNode = new BinTreeNode(value, null, null);
          stack.push(binTreeNode);
          commaIndex = -1;
        }
        binTreeNode = stack.pop();
        if(!stack.isEmpty()) {
          BinTreeNode parentNode = stack.peek();
          if (parentNode != null) {
            if (parentNode.left == null) {
              parentNode.left = binTreeNode;
            } else {
              parentNode.right = binTreeNode;
            }
          }
        }
      }


    }

    return binTreeNode;

  }

  public BinTreeNode deserialize(String str) {
    char[] chars = str.toCharArray();

    return parseNode(chars);
  }

  public static void main(String[] args) {
    BinTreeNode leftleftright = new BinTreeNode("left.left.left", null, null);
    BinTreeNode leftleft = new BinTreeNode("left.left", null, leftleftright);
    BinTreeNode left = new BinTreeNode("left", leftleft, null);
    BinTreeNode right = new BinTreeNode("right", null, null);
    BinTreeNode root = new BinTreeNode("root", left, right);
    String str = new BinTreeManipulator().serialize(root);
    System.out.println(str);
    BinTreeNode root1 = new BinTreeManipulator().deserialize(str);
  }
}
