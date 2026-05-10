class Solution {
    public int maxArea(int[] heights) {
        if(heights==null || heights.length<2)
        return 0;
        int left=0;
        int right=heights.length-1;
        int maxWater=0;
        while(left<right)
        {
            int currentWidth=right-left;
            int currentHeight=Math.min(heights[left],heights[right]);
            int currentWater=currentWidth*currentHeight;
            maxWater=Math.max(currentWater,maxWater);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxWater;
    }
}
