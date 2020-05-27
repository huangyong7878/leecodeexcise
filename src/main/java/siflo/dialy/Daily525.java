package siflo.dialy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This problem was asked by Google.
 *
 * We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.
 *
 * Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 *
 * You may assume each element in the array is distinct.
 *
 * For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */
public class Daily525 {
    static public int topDownMergeSoft(int[] a,int low,int h){
        int swap = 0;
        if(low<h) {
            int mid = (h+low)/2;
            swap+=topDownMergeSoft(a,low,mid);
            swap+=topDownMergeSoft(a,mid+1,h);
            swap+=merge(a,low,mid,h);
        }
        return swap;
    }
    static public int merge(int[] a ,int low,int mid,int h){
        int[] aux = new int[h-low+1];
        int i = low,j=mid+1;
        int k = 0;
        int swap = 0;
        while(i<=mid && j<=h){
            if(a[i]<=a[j])
                aux[k++] = a[i++];
            else {
                aux[k++] = a[j++];
                //这个地方是需要注意的， 因为左边的数组是排序的，所以如果a[i]....a[mid]都需要交换
                swap += (mid + 1) - (i);

            }
        }

        while(i<=mid)
            aux[k++] = a[i++];
        while(j<=h)
            aux[k++] = a[j++];
        for(int m=0;m<aux.length;m++)
            a[m+low] = aux[m];
        return swap;
    }

    public static void main(String[] args) {

       int[] a = new int[]{2,4,1,3,5};
       int is =  topDownMergeSoft(a,0,a.length-1);
       System.out.println(is);


    }
}
