class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || cost==null)
        return -1;
        int totalgas=0;
        int totalcost=0;
        int currenttank=0;
        int res=0;
        for(int i=0;i<gas.length;i++)
        {
            totalgas+=gas[i];
            totalcost+=cost[i];
            currenttank+=gas[i]-cost[i];
            if(currenttank<0){
            res=i+1;
            currenttank=0;}
        }
        if(totalcost>totalgas)
        return -1;

        return res;

    }
}
