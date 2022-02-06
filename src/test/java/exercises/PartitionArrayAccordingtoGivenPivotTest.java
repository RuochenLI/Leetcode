package exercises;

import contest.biweekly71.PartitionArrayAccordingtoGivenPivot;
import org.junit.Test;

public class PartitionArrayAccordingtoGivenPivotTest {
    @Test
    public void happyCase() {
        new PartitionArrayAccordingtoGivenPivot().pivotArray(new int[]{9,12,5,10,14,3,10}, 10);
    }
}
