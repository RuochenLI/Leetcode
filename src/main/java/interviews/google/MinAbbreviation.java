package interviews.google;

public class MinAbbreviation {

    public String minAbbreviation(String target, String[] dictionary) {
        boolean flag = true;
        long[] wordMask = new long[dictionary.length];
        for (int i = 0; i < dictionary.length; i++) {
            flag = false;
            String word = dictionary[i];
            if (word.length() == target.length()) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) != target.charAt(j)) {
                        wordMask[i] += Math.pow(2, word.length() - j - 1);
                    }
                }
            }
        }

        if (flag) return String.valueOf(target.length());

        long initialBitMask = 0;
        long bitMask = 0;
        boolean notFound = true;
        int bitCount = 0;
        while (bitCount < target.length() && notFound) {
            initialBitMask += Math.pow(2, bitCount);
            bitMask = initialBitMask;
            for (int j = 0; j < target.length(); j++) {
                bitMask <<= j;
                boolean notMatch = false;
                for (int k = 0; k < dictionary.length; k++) {
                    if ((wordMask[k] & bitMask) == 0) {
                        notMatch = true;
                        break;
                    }
                }
                if (!notMatch) {
                    notFound = false;
                    break;
                }
            }
            bitCount++;
        }
        String bitMaskInBinary = Long.toBinaryString(bitMask);
        StringBuilder ansBuilder = new StringBuilder().append(target.length() - bitMaskInBinary.length());
        for (int i = 0; i < bitMaskInBinary.length(); i++) {
            int count = 0;
            while (i < bitMaskInBinary.length() && bitMaskInBinary.charAt(i) == '0') {
                count++;
                i++;
            }
            if (count != 0) ansBuilder.append(count);
            if (i < bitMaskInBinary.length()) ansBuilder.append(target.charAt(target.length() - bitMaskInBinary.length() + i));
        }
        return ansBuilder.toString();
    }
}
