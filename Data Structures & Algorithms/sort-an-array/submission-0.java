class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int x: nums)
        {
            pq.add(x);
        }
        int i=0;
        while(!pq.isEmpty())
        {
            nums[i]=pq.poll();
            i++;
        }
        return nums;
    }
}