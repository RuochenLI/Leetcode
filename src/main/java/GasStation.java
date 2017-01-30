/**
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
public final class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int[] gap = new int[gas.length];
        //calculate the gap between the gas and the cost
        while (index < gas.length) {
            gap[index] = gas[index] - cost[index];
            index++;
        }
        
        int pointer = 0;
        boolean canAchieved = false;
        while (pointer < gas.length && !canAchieved) {
            if (gap[pointer] >= 0) {
                index = updateIndex(pointer + 1, gap.length);
                int restGas = gap[pointer];
                canAchieved = isCanAchieved(index, gap, pointer, restGas);
            }

            pointer++;
        }
        
        if (!canAchieved) {
            return -1;
        } else {
            return --pointer;
        }
    }

    private boolean isCanAchieved(int index, int[] gap, int pointer, int restGas) {
        boolean canAchieved = true;
        while (index != pointer && canAchieved) {
            restGas += gap[index];
            if (restGas < 0) {
                canAchieved = false;
            }
            index++;
            index = updateIndex(index, gap.length);
        }
        return canAchieved;
    }

    private int updateIndex(int index, int length) {
        if (index >= length) {
            index = 0;
        }
        return index;
    }
}
