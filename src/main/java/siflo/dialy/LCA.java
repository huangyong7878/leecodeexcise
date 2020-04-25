package siflo.dialy;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=GnliEfQo114&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=10&t=0s
 */
public class LCA {

  class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int v) {
      this.val = v;
    }
  }

  Stack<Integer> pathToX(TreeNode node, int x) {

    if (node.val == x) {
      Stack<Integer> stack = new Stack<>();
      stack.push(x);
      return stack;
    }
    Stack<Integer> left = pathToX(node.left, x);
    if (left != null) {
      left.push(node.val);
      return left;
    }
    Stack<Integer> right = pathToX(node.right, x);
    if (right != null) {
      right.push(node.val);
      return right;
    }
    return null;
  }

  public Integer lca(TreeNode root, int x) {
    Integer lcaV = null;
    Stack<Integer> ls = pathToX(root.left, x);
    Stack<Integer> rs = pathToX(root.right, x);
    while (ls != null && !ls.isEmpty() && rs != null && !rs.isEmpty()) {
      int r = 0;
      if ((r = ls.pop()) == rs.pop()) {
        lcaV = r;
      } else {
        break;
      }
      ;
    }
    return lcaV;
  }
}
