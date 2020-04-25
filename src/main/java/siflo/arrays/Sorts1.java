package siflo.arrays;

public class Sorts1 {
  public void swap(int i,int j,int[] nums){

  }
  public void bubble(int[] a){
    boolean flag = true;
    for(int i=a.length-1;i>=0 &&flag ;i--){
      flag = false;
      for(int j=0;j<i;j++){
        if(a[j]>a[j+1]){
          swap(j,j+1,a);
          flag = true;
        }
      }
    }
  }


}
