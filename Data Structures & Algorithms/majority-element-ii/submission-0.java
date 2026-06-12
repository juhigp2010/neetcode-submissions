class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> li = new ArrayList<Integer> ();
        if(nums==null || nums.length==0)
        return li;
        int count1=0;
        int count2=0;
        int res1=0;
        int res2=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[res1]==nums[j])
            count1++;
           else if(nums[res2]==nums[j])
            count2++;
           else if(count1==0){
           res1=j;
           count1=0;}
           else if(count2==0){
            res2=j;
            count2=0;
           }
           else
           {
            count1--;
            count2--;
           }

        }
        count1=0;
        count2=0;
        for(int x: nums)
        {
            if(nums[res1]==x)
            count1++;
            if(nums[res2]==x)
            count2++;
        }
        if(res1!=res2)
        {
        if(count1>nums.length/3)
        li.add(nums[res1]);
        if(count2>nums.length/3)
        li.add(nums[res2]);
        }
        else
        {
            li.add(nums[res1]);
        }
        return li;

    }
}