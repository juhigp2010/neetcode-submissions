class Solution {
    public int maxProfit(int[] arr) {

      if(arr.length==0 || arr.length==1)
            return 0;
        int buy = arr[0];
        int profit = 0;

        for (int j : arr) {
            // Update profit if selling at the current price yields a higher return
            profit = Math.max(profit, (j - buy));

            // Update the 'buy' price if a new minimum price is found
            buy = Math.min(buy, j);
        }

        return profit;
        
    }
    
    }

