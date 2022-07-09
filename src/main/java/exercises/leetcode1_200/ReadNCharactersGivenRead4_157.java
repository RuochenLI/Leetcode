package exercises.leetcode1_200;

public class ReadNCharactersGivenRead4_157 {
    public int read(char[] buf, int n) {
        int tmp;
        int length = 0;
        char[] bufTmp = new char[4];
        while((tmp = read4(bufTmp)) != 0) {
            for (int i = 0; i < tmp && length < n; i++) {
                buf[length] = bufTmp[i];
                length++;
            }
        }
        return  length;
    }

    private int read4(final char[] bufTmp) {
        return 0;
    }
}
