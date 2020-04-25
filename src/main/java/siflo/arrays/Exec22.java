package siflo.arrays;

public class Exec22 {

  public int maxProfit(int[] prices) {
    int profit = 0;

    for (int day = 1; day < prices.length; day++) {
      if (prices[day] > prices[day - 1]) {
        profit += prices[day] - prices[day - 1];
      }
    }
    return profit;
  }

  public static void main(String[] args) throws Exception {
    int prices[] = {1, 6, 2, 3, 1};
    System.out.println(new Exec22().maxProfit(prices));
  }
}
