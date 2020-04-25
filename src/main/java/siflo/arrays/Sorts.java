package siflo.arrays;

import java.util.Arrays;

public class Sorts {

  private static void swap(int i, int j, int[] a) {
    a[i] = a[i] ^ a[j];
    a[j] = a[i] ^ a[j];
    a[i] = a[j] ^ a[i];
  }

  /**
   * 冒泡排序是倒着来的，每次拍完后，最后面的元素就是最大的 第一次 n最大 第二次 n-1最大 类推 加个flag，如果某一次排序是没有发生交换，就可以提前结束了
   */
  public static void bubble(int[] a) {
    boolean flag = true;
    for (int i = a.length - 1; i >= 0 && flag; i--) {
      flag = false;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          swap(j, j + 1, a);
          flag = true;
        }
      }
    }
  }

  public static void insert(int[] arr) {
    int len = arr.length;
    for (int i = 1; i < len; i++) {
      if (arr[i] < arr[i - 1]) {      //发生逆序，往前插入
        int temp = arr[i];
        int j;
        for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
          arr[j + 1] = arr[j];
        }
        arr[j + 1] = temp;
      }
    }
  }

  /**
   * 选择排序 每次从待排序的数组中选出最小的 放在已经排位的后面
   */
  public static void select(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      if (i != min) {
        swap(i, min, a);
      }
    }
  }
  static int partion(int l,int h,int[]a){
    int priovt = a[l];
    int pos = l;
    for(int i = l+1;i<=h;i++){
      if(a[i]<priovt){
        pos++;
        if(pos!=i){
          swap(pos,i,a);
        }
      }
    }
    a[l] = a[pos];
    a[pos] = priovt;
    return pos;

  }
  static void quickSelect(int l,int h,int[]a){
    if(l<h){
      int p = partion(l,h,a);
      quickSelect(l,p-1,a);
      quickSelect(p+1,h,a);
    }
  }
  public static void quick(int[] a){
    quickSelect(0,a.length-1,a);
  }


  public static void main(String[] args) {
//    int[] a = new int[]{10, 36, 27, 92, 48, 78, 25, 54, 4, 28};
    int[] a = new int[]{4,3,2,1};

    quick(a);
    Arrays.stream(a).forEach(i -> System.out.println(i));
  }
}
