class Solution {
    public int maxProfit(int[] prices) {

       return maxProfitSupport(prices,0,prices.length);
        
    }
    public static int maxProfitSupport(int[] arr,int start,int end)
    {
        if(start>=end)
        return 0;
        int profit=0;
        for(int i=0;i<end;i++)
        {
            for(int j=i+1;j<end;j++)
            {
                if(arr[j]>arr[i])
                {
                    int currProfit=arr[j]-arr[i];
                    profit=Math.max(profit,currProfit);
                }
            }
        }
        return profit;
    }
}
