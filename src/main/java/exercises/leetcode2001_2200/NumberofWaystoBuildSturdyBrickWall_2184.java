package exercises.leetcode2001_2200;

/**
 * 2184. Number of Ways to Build Sturdy Brick Wall
 */
public class NumberofWaystoBuildSturdyBrickWall_2184 {
    // dp[i][state]: the nb of brick plans for the first i rows and using state for the i-th row
    // dp[i][state] = sum{dp[i - 1][state0]} for all state0 ^ state == 0
    // todo
}
