class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones==null)
        return 0;

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones)
        {
            pq.add(i);
        }
       
        while(pq.size()!=1 && !pq.isEmpty())
        {
            int x=pq.poll();
            int y=pq.poll();
            if(x-y==0)
            continue;
            else
            pq.add(x-y);
        }
        if(!pq.isEmpty())
        return pq.poll();
       
       return 0;
    }
}
