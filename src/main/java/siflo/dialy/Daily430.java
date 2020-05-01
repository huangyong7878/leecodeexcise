package siflo.dialy;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.<BR>
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:<BR>
 *
 * 10 = max(10, 5, 2)<BR>
 * 7 = max(5, 2, 7)<BR>
 * 8 = max(2, 7, 8)<BR>
 * 8 = max(7, 8, 7)<BR>
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
public class Daily430 {
  static void solution(int[] a,int  k){
    int max = Integer.MIN_VALUE;
    int l=0,r=0;
    int d = 0;
    int max1 = Integer.MIN_VALUE;
    for(;r<a.length;r++){
      max=Math.max(a[r],max);
      if(r>0)
        max1 = Math.max(a[r],max1);
      d++;
      if(d==k) {
        System.out.println(max);
        max = Integer.MIN_VALUE;
        l++;
        for(int z=l;z<=r;z++)
          max = Math.max(a[z],max);
        d--;
      }


    }
  }






    // A Dequeue (Double ended queue) based method for printing maximum element of
    // all subarrays of size k
    static void printMax(int arr[], int k)
    {
      int n = arr.length;
      // Create a Double Ended Queue, Qi that will store indexes of array elements
      // The queue will store indexes of useful elements in every window and it will
      // maintain decreasing order of values from front to rear in Qi, i.e.,
      // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
      Deque<Integer> Qi = new LinkedList<Integer>();

      /* Process first k (or first window) elements of array */
      int i;
      for (i = 0; i < k; ++i) {
        // For every element, the previous smaller elements are useless so
        // remove them from Qi
        while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
          Qi.removeLast(); // Remove from rear

        // Add new element at rear of queue
        Qi.addLast(i);
      }

      // Process rest of the elements, i.e., from arr[k] to arr[n-1]
      for (; i < n; ++i) {
        // The element at the front of the queue is the largest element of
        // previous window, so print it
        System.out.print(arr[Qi.peek()] + " ");

        // Remove the elements which are out of this window
        while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
          Qi.removeFirst();

        // Remove all elements smaller than the currently
        // being added element (remove useless elements)
        while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
          Qi.removeLast();

        // Add current element at the rear of Qi
        Qi.addLast(i);
      }

      // Print the maximum element of last window
      System.out.print(arr[Qi.peek()]);
    }


// This code is contributed by Sumit Ghosh

  public static void main(String[] args) {
    int[] a = {90, 1, 78, 79, 57, 89, 56};
    printMax(a,3);

  }
}
