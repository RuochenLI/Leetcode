
/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

 Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

 Example 1:
 Input: [1,1,2,2,2]
 Output: true

 Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 Example 2:
 Input: [3,3,3,3,4]
 Output: false

 Explanation: You cannot find a way to form a square with all the matchsticks.
 * Created by Ruochen on 31/01/2017.
 */
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

        for (int j = 0; j < 4; j++) {
            if (sides[j] >= numList[indicator]) {
                sides[j] -= numList[indicator];
                if (findSolution(numList, sides, indicator + 1)) return true;
                sides[j] += numList[indicator];
            }
        }

        return false;
    }

    private boolean finish(long[] sides) {
        for (long side : sides) {
            if (side != 0) {
                return false;
            }
        }

        return true;
    }
}
