class Solution {
    public int maxProfit(int[] arr) {

      if(arr.length==0 || arr.length==1)
            return 0;
        int buy=arr[0];
        int profit =0;
        for(int i=0;i<arr.length;i++)
        {
            profit=Math.max(profit,(arr[i]-buy));
            buy=Math.min(buy,arr[i]);
        }
        return profit;
        
    }
    
    }

