package siflo.dialy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import siflo.datastructure.ListNodeUtils;

/**
 * This problem was asked by Snapchat.
 *
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class Daily503 {


  /**
   * 堆真的是个好东西
   * @param timeIntevals
   * @return
   */
  static int solution(int[][] timeIntevals){
    Arrays.sort(timeIntevals, Comparator.comparing((int[]a)->a[0]));
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int count = 0;
    for (int[] itv : timeIntevals) {
      if (heap.isEmpty()) {
        count++;
        heap.offer(itv[1]);
      } else {
        if (itv[0] >= heap.peek()) {
          heap.poll();
        } else {
          count++;
        }

        heap.offer(itv[1]);
      }
    }

    return count;


  }

  public static void main(String[] args) {
   int[][] a = {{30,75},{0,50},{60,150}};
   System.out.println(solution(a));
  }
}
