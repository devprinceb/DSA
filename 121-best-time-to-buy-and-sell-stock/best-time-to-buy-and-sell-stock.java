class Solution {
    public int maxProfit(int[] prices) {

        int buyStockIndex = 0;
        int sellStockIndex = 0;
        int maxProfit = 0;

        for (int i=1; i < prices.length; i++ ) {
            if(prices[i] < prices[buyStockIndex]){
                if( i != (prices.length-1)) buyStockIndex = i;
                
            }
            if(sellStockIndex < buyStockIndex && i < prices.length-1){ sellStockIndex = i+1; }
            if(prices[i] > prices[sellStockIndex] && buyStockIndex <= sellStockIndex){
                
                sellStockIndex = i;
            }
            if(buyStockIndex < sellStockIndex && maxProfit < prices[sellStockIndex] - prices[buyStockIndex]  ) maxProfit = prices[sellStockIndex] - prices[buyStockIndex];
        }
        if(buyStockIndex > sellStockIndex ) return 0;
        return maxProfit;
        
    }
}