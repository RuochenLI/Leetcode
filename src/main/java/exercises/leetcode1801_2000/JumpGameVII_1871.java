package exercises.leetcode1801_2000;

/**
 * 1871. Jump Game VII
 */
public class JumpGameVII_1871 {
    // TLE
    public boolean canReach0(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        boolean[] jump = new boolean[s.length()];
        jump[n - 1] = true;
        ;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                int pt = Math.min(i + maxJump, n - 1);
                while (pt >= i + minJump && !jump[pt]) {
                    pt--;
                }
                jump[i] = pt >= i + minJump && jump[pt];
            }
        }
        return jump[0];
    }

    /*
    dp[i] = true if we can reach s[i].
    pre means the number of previous position that we can jump from.

    - It's a bottom-up DP implementation. The boolean value represents whether this position is reachable from start. So the first step is to generate the table. Here the table was pre-labeled True or False, thus '1's are already labeled False.
    - To determine the state of dp[i], one need to check the states in window dp[i-maxJ : i-minJ], because any one of them can reach i if it's labeled True.
    - Then you need to check if there is a True in this window. Notice that this is a sliding window problem, so you don't need to calculate it everytime. You only need to remove the effect from dp[i-maxJ-1] and add the dp[i-minJ]. This is done by these two lines of code pre += dp[i - minJ] and pre -= dp[i - maxJ - 1]
    - The if statements if i >= minJ: and if i > maxJ: are dealing with the initial boundary.
     */
    public boolean canReach(String s, int minJ, int maxJ) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJ && dp[i - minJ]) {
                pre++;
            }
            if (i > maxJ && dp[i - maxJ - 1]) {
                pre--;
            }
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}
