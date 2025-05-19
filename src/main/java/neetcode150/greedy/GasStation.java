package neetcode150.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum()<Arrays.stream(cost).sum()) return -1;
        int[] diff = new int[gas.length];
        for(int i=0;i<gas.length;i++){
            diff[i] = gas[i]-cost[i];
        }
        int total = 0;
        int curr = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            total += diff[i];
            curr += diff[i];
            if(curr<0){
                curr = 0;
                start = i+1;
            }
        }
        return total >= 0 ? start : -1;
    }
}
