package exercises.leetcode1_200;

public class ReadNCharactersGivenRead4II_158 {
    int bufReadP = 0;
    int bufWriterP = 0;
    char[] buffer = new char[4];

    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            if (bufReadP == bufWriterP) {
                bufWriterP = read4(buffer);
                bufReadP = 0;
                if (bufWriterP == 0) {
                    return i;
                }
            }
            buf[i] = buffer[bufReadP++];

        }
        return n;
    }

    private int read4(final char[] buffer) {
        return 4;
    }
}
