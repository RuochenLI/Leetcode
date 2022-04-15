package interviews.facebook.panel;

public class ChangeInAForeignCurrency {
    /**
     * Change in a Foreign Currency
     * You likely know that different currencies have coins and bills of different denominations. In some currencies, it's actually impossible to receive change for a given amount of money. For example, Canada has given up the 1-cent penny. If you're owed 94 cents in Canada, a shopkeeper will graciously supply you with 95 cents instead since there exists a 5-cent coin.
     * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of money targetMoney. Both the denominations and target amount will be given in generic units of that currency.
     * Signature
     * boolean canGetExactChange(int targetMoney, int[] denominations)
     * Input
     * 1 ≤ |denominations| ≤ 100
     * 1 ≤ denominations[i] ≤ 10,000
     * 1 ≤ targetMoney ≤ 1,000,000
     * Output
     * Return true if it's possible to receive exactly targetMoney given the available denominations, and false if not.
     * Example 1
     * denominations = [5, 10, 25, 100, 200]
     * targetMoney = 94
     * output = false
     * Every denomination is a multiple of 5, so you can't receive exactly 94 units of money in this currency.
     * Example 2
     * denominations = [4, 17, 29]
     * targetMoney = 75
     * output = true
     * You can make 75 units with the denominations [17, 29, 29].
     */
    boolean canGetExactChange(int targetMoney, int[] denominations) {
        boolean[] dp = new boolean[targetMoney + 1];
        dp[0] = true;

        for (int i = denominations[0]; i <= targetMoney; i++) {
            for (int j = 0; j < denominations.length; j++){
                if (i >= denominations[j]) {
                    dp[i] = dp[i] || dp[i - denominations[j]];
                }
            }
        }

        return dp[targetMoney];
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ChangeInAForeignCurrency().run();
    }
}
