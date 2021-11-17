package google.interviews;

public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] arr) {
        int[] digits = new int[10];
        for (final int num : arr) {
            digits[num]++;
        }

        if (digits[0] == 0 && digits[1] == 0 && digits[2] == 0) return "";

        return buildLargestTime(new StringBuffer(), 0, digits);
    }

    private String buildLargestTime(final StringBuffer stringBuffer, final int pointer, final int[] digits) {
        String result;
        if (pointer == 0) {
            result = buildTime(stringBuffer, pointer, digits, 2);
            if (!result.equals("")) return result;
        }

        if (pointer == 1) {
            int largestNum = stringBuffer.charAt(0) == '2' ? 3 : 9;
            result = buildTime(stringBuffer, pointer, digits, largestNum);
            if (!result.equals("")) return result;
        }

        if (pointer == 2) {
            stringBuffer.append(':');
            result = buildTime(stringBuffer, pointer, digits, 5);
            if (!result.equals("")) return result;
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (pointer == 3) {
            for (int i = 9; i >= 0; i--) {
                if (digits[i] > 0) {
                    stringBuffer.append(i);
                    digits[i]--;
                    result = stringBuffer.toString();
                    return result;
                }
            }
        }

        return "";
    }

    private String buildTime(final StringBuffer stringBuffer,
                             final int pointer,
                             final int[] digits,
                             final int largestNum) {
        for (int i = largestNum; i >= 0; i--) {
            if (digits[i] > 0) {
                stringBuffer.append(i);
                digits[i]--;
                String result = buildLargestTime(stringBuffer, pointer + 1, digits);
                if (!result.equals(""))
                    return result;
                digits[i]++;
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
        return "";
    }
}
