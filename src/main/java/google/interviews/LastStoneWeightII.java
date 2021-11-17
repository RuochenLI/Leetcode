package google.interviews;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (final int stone : stones) {
            total += stone;
        }
        int half = total / 2;

        int maxInHalf = putStone(stones.length - 1, half, stones);
        return total - 2 * maxInHalf;
    }

    private int putStone(final int pointer, final int remaining, final int[] stones) {
        if (pointer == 0) {
            return remaining > stones[pointer] ? stones[0] : 0;
        }

        return Math.max(putStone(pointer - 1, remaining, stones), putStone(pointer - 1, remaining - stones[pointer],
                                                                           stones) + stones[pointer]);
    }
}
