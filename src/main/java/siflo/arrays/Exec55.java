package siflo.arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 */
public class Exec55 {

  public int bruteforce(int[] prices){
    if(prices.length==1)
      return 0;
    int maxPrices = 0;
    int outter = 0;
    while( outter<prices.length){
      int b = prices[outter];
      for(int inner = outter+1;inner<prices.length;inner++){
        if(prices[inner]>b)
          maxPrices = Math.max(maxPrices,prices[inner]-b);
      }
      outter++;
    }

    return maxPrices;
  }

  public int slipeWidow(int[] prices){
    int size = prices.length;
    int min_price = Integer.MAX_VALUE; //存储最低售价
    int max_profit = 0; //存储最高利润
    for(int i = 0; i < size; i++)
    {
      min_price = Math.min(prices[i], min_price); //更新最低售价
      int profit = prices[i] - min_price; //计算利润
      max_profit = Math.max(profit, max_profit); //跟新最高利润
    }
    return max_profit;
  }
}
