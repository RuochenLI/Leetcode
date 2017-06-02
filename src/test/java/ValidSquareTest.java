import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by ruli on 6/2/2017.
 */
public class ValidSquareTest {

    @Test
   public void testCase1(){
       assertTrue(ValidSquare.validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    }

    @Test
   public void testCase2() {
       assertFalse(ValidSquare.validSquare(new int[]{0,0}, new int[]{-1,0}, new int[]{1,0}, new int[]{0,1}));
    }

   @Test
   public void testCase3() {
      assertFalse(ValidSquare.validSquare(new int[]{0,0}, new int[]{5,0}, new int[]{5,4}, new int[]{0,4}));
   }
}
