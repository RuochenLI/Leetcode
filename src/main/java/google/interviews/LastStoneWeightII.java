package google.interviews;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        int maxInHalf = 0;
        for (final int stone : stones) {
            total += stone;
        }
        int half = total / 2;
        int[][] sum = new int[stones.length][half + 1];
        for (int i = stones[0]; i <= half; i++)
            sum[0][i] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            for (int w = 0; w <= half; w++) {
                if (w >= stones[i]){
                    sum[i][w] = Math.max(sum[i - 1][w], sum[i - 1][w - stones[i]] + stones[i]);
                } else {
                    sum[i][w] = sum[i - 1][w];
                }
                maxInHalf = Math.max(sum[i][w], maxInHalf);
            }
        }
        return total - 2 * maxInHalf;
    }

    public int lastStoneWeightII1(int[] stones) {
        int total = 0;
        for (final int stone : stones) {
            total += stone;
        }
        int half = total / 2;
        int[] sum = new int[half + 1];
        for (int i = 1; i <= stones.length; i++) {
            for (int w = half; w >= stones[i - 1]; w--) {
                sum[w] = Math.max(sum[w], sum[w - stones[i - 1]] + stones[i - 1]);
            }
        }
        return total - 2 * sum[half];
    }

    //todo: with dfs
}
