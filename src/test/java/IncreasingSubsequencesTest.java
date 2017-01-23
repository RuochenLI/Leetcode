import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ruochen on 22/01/2017.
 */
public class IncreasingSubsequencesTest {

    @Test
    public void testIncreasingSubsequences() {

        List<List<Integer>> subsequences = new IncreasingSubsequences().findSubsequences(new int[]{4, 6, 7, 7});

        subsequences.forEach(subsequence ->{
            subsequence.forEach(System.out::print);
            System.out.println();
        });

        assertEquals(8, subsequences.size());

    }

}
