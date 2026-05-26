class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits==null || fruits.length==0)
        return 0;

        int low=0;
        int high=0;
        int maxFruits=0;
        HashMap<Integer,Integer> hs =new HashMap<>();
        for(high=0;high<fruits.length;high++)
        {
            hs.put(fruits[high],hs.getOrDefault(fruits[high],0)+1);

            while(hs.size()>2)
            {
                hs.put(fruits[low],hs.get(fruits[low])-1);
                if(hs.get(fruits[low])==0)
                {hs.remove(fruits[low]);}
                low++;
            }
            maxFruits=Math.max(maxFruits,high-low+1);
        }
        return maxFruits;
    }
}