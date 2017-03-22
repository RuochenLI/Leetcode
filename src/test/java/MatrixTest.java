import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruochen on 19/03/2017.
 */
public class MatrixTest {
    @Test
    public void testCase1() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 1, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 1, 1)
        );

        new Matrix().updateMatrix(matrix);
    }
}
