class Solution {
    public int missingNumber(int[] nums) {
       
  int n=nums.length;
  int sum=(n*(n+1))/2;


int arraySum=0;
for(int i:nums)
{
arraySum+=i;
}
return (sum-arraySum);
        
    }
}
