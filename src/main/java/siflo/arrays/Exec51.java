package siflo.arrays;

public class Exec51 {
  static public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v){val = v;}
  }

  static TreeNode insert(int left,int right,int[] nums){

    if(left>right)
      return null;

    int middle = (right+left)/2;
    TreeNode node = new TreeNode(nums[middle]);
    node.left = insert(left,middle-1,nums);
    node.right = insert(middle+1,right,nums);
    return node;
  }
  public static TreeNode sortedArrayToBST(int[] nums) {


    if(nums==null)
      return null;
    return insert(0,nums.length-1,nums);



  }

  public static void main(String[] args) {
    sortedArrayToBST(new int[]{-10,-3,0,5,9});
  }
}
