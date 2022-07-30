package exercises.leetcode2001_2200;

/**
 * 2162. Minimum Cost to Set Cooking Time
 */
public class MinimumCostToSetCookingTime_2162 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int mins = targetSeconds / 60, secs = targetSeconds % 60;
        return Math.min(cost(mins, secs, startAt, moveCost, pushCost),
                        cost(mins - 1, secs + 60, startAt, moveCost, pushCost));
    }

    private int cost(int mins, int secs, int startAt, int moveCost, int pushCost) {
        if (mins > 99 || secs > 99 || mins < 0 || secs < 0) {
            return Integer.MAX_VALUE;
        }
        String s = Integer.toString(mins * 100 + secs);
        char curr = (char) (startAt + '0');
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curr) {
                res += pushCost;
            } else {
                res += pushCost + moveCost;
                curr = s.charAt(i);
            }
        }
        return res;
    }

    public int minCostSetTime1(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int mm = targetSeconds / 60;
        int ss = targetSeconds % 60;
        int cost = Integer.MAX_VALUE;
        if (mm < 100) {
            cost = getCost(mm, ss, startAt, moveCost, pushCost);
        }

        if (ss + 60 < 100) {
            mm--;
            ss += 60;
            cost = Math.min(cost, getCost(mm, ss, startAt, moveCost, pushCost));
        }

        return cost;
    }

    private int getCost(final int mm, final int ss, final int startAt, final int moveCost, final int pushCost) {
        char currentPos = (char) (startAt + '0');
        if (mm == 0 && ss == 0) {
            return getCostForSinglePush(currentPos, '0', moveCost, pushCost);
        }

        String mms = String.valueOf(mm);
        String sss = ss < 10 && mm != 0 ? "0" + ss : String.valueOf(ss);
        int cost = 0;

        // for mm
        if (mm != 0) {
            cost += getCostForSinglePush(currentPos, mms.charAt(0), moveCost, pushCost);
            currentPos = mms.charAt(0);
            if (mm >= 10) {
                cost += getCostForSinglePush(currentPos, mms.charAt(1), moveCost, pushCost);
                currentPos = mms.charAt(1);
            }
        }

        // for ss
        cost += getCostForSinglePush(currentPos, sss.charAt(0), moveCost, pushCost);
        currentPos = sss.charAt(0);
        if (sss.length() > 1) {
            cost += getCostForSinglePush(currentPos, sss.charAt(1), moveCost, pushCost);
        }

        return cost;
    }

    private int getCostForSinglePush(final char currentPos, final char target, final int moveCost, final int pushCost) {
        int cost = 0;
        if (currentPos != target) {
            cost += moveCost;
        }
        cost += pushCost;
        return cost;
    }
}
