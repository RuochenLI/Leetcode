public final class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        long side = sum / 4;
        return findSolution(nums, new long[]{side, side, side, side}, 0);
        
    }
    
    private boolean findSolution(int[] numList, long[] sides, int indicator) {
        if (indicator >= numList.length && finish(sides)) {
            return true;
        }
        
        for (int i = indicator; i < numList.length; i++) {
            boolean noOneMatchCanBePutInTheSide = true;
            for (int j = 0; j < 4; j++) {
                if (sides[j] >= numList[i]) {
                    noOneMatchCanBePutInTheSide = false;
                    sides[j] -= numList[i];
                    if (findSolution(numList, sides, indicator + 1)) return true;
                    sides[j] += numList[i];
                }
            }
            if (noOneMatchCanBePutInTheSide) return false;
        }
        
        return false;
    }
    
    private boolean finish(long[] sides) {
        for (long  side : sides){
            if (side != 0) {
                return false;
            }
        }
        
        return true;
    }
}
