package siflo.dialy;

import java.util.Stack;

/**
 * 给你一个二叉树，判断他是否为二叉排序树
 */
public class BinarySearchTree {

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
  }

  boolean isBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    int pre = Integer.MIN_VALUE;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        if (p.val <= pre) {
          return false;
        }
        pre = p.val;
        p = p.right;
      }
    }
    return true;

  }
}
