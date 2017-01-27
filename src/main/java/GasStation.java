public final class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int[] gap = new int[gas.length];
        //calculate the gap between the gas and the cost
        while (index < gas.length) {
            gap[index] = gas[index] - cost[index];
            index++;
        }
        
        //find the most gap
        index = 1;
        int maxIndex = 0;
        int max = gap[0];
        while (index < gap.length) {
            if (max < gap[index]) {
                max = gap[index];
                maxIndex = index;
            }
            index++;
        }
        
        //simulate
        int targetIndex = maxIndex;
        int restGas = gap[targetIndex];
        index = targetIndex + 1;
        boolean canNotAchieved = false;
        while (index != targetIndex && !canNotAchieved) {
            if (index >= gap.length) {
                index = 0;
            }
            restGas += gap[index];
            if (restGas < 0) {
                canNotAchieved = true;
            }
            index++;
                     if (index >= gap.length) {
            index = 0;
         }
        }
        
        if (canNotAchieved) {
            return -1;
        } else {
            return targetIndex;
        }
    }
}
