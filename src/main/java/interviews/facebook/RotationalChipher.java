package interviews.facebook;

public class RotationalChipher {
    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(getRotatedChar(c, rotationFactor));
        }
        return sb.toString();
    }

    char getRotatedChar(char c, int factor) {
        if (c <= 'z' && c >= 'a') {
            char result = (char) (c + factor % 26);
            if (result > 'z') result = (char) (result - 26);
            return result;
        }

        if (c <= 'Z' && c >= 'A') {
            char result = (char) (c + factor % 26);
            if (result > 'Z') result = (char) (result - 26);
            return result;
        }

        if (c >= '0' && c <= '9') {
            char result = (char) (c + factor % 10);
            if (result > '9') result = (char) (result - 10);
            return result;
        }

        return c;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalChipher().run();
    }
}
