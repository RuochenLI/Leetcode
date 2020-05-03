package exercises;

import exercises.RemoveBoxes;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 28/03/2017.
 */
public class RemoveBoxesTest {

    @Test
    public void textRemoveBox() {
        int[] boxes = new int[]{1,3,2,2,2,3,4,3,1};
        assertEquals(23, new RemoveBoxes().removeBoxes(boxes));
    }
}
