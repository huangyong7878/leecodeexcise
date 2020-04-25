package siflo.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import siflo.dialy.BinarySearchTree;

public class BTree {


  /**
   * 先序遍历
   * @param root
   * @return
   */
  public static List<TreeNode> preOrder(TreeNode root){
    List<TreeNode> nodes = new ArrayList<>();
    TreeNode p = root;
    Stack<TreeNode> stack = new Stack<>();
    while(p!=null||!stack.isEmpty()){

      while(p!=null){
        if(p.left!=null ||p.right!=null)
        {
          nodes.add(p);
        }
        stack.push(p);
        p=p.left;
      }
      if(!stack.isEmpty()){
        p = stack.pop();
        if(p.left==null&&p.right==null)
          nodes.add(p);
        p = p.right;

      }
    }
    return nodes;
  }

  public static List<TreeNode> postOrder(TreeNode root){
    List<TreeNode> nodes = new ArrayList<>();
    TreeNode p = root;
    class TreeNodeData {
      TreeNode node;
      int flag;
    }

    int left = 1;//在辅助栈里表示左节点
    int right = 2;//在辅助栈里表示右节点
    Stack<TreeNodeData> stack = new Stack<>();
    while (p!=null || !stack.isEmpty()){
      TreeNodeData td=null;
      while(p!=null){
        td = new TreeNodeData();
        td.flag = left;
        td.node = p;
        stack.push(td);
        p = p.left;
      }


      while (!stack.isEmpty() && (stack.peek().flag==right)){
        TreeNodeData q = stack.pop();
        nodes.add(q.node);

      }

      if (!stack.isEmpty()){
        stack.peek().flag = right;
        p=stack.peek().node.right;
      }
    }
    return nodes;
  }

  public static void main(String[] args) {
    TreeNode root = BinTreeNodeUtils.stringToTreeNode("[5,1,4]");
    postOrder(root).stream().forEach(n->System.out.println(n.val));
  }
}
