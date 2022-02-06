package interviews;

import java.util.Arrays;

public class SwissQuote {
    public int solution(String S, int[] C) {
        int cost = 0;
        int pointer = 1;
        int tmp = C[0];
        int max = C[0];
        boolean flag = false;
        while (pointer < S.length()) {
            if (S.charAt(pointer) == S.charAt(pointer - 1)) {
                tmp += C[pointer];
                max = Math.max(max, C[pointer]);
                flag = true;
            } else {
                if (flag) cost = cost + tmp - max;
                tmp = C[pointer];
                max = C[pointer];
                flag = false;
            }
            pointer++;
        }
        if (flag) cost = cost + tmp - max;
        return cost;
    }
}
