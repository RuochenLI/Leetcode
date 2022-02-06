package google.interviews;

import interviews.google.MeetingRoomIII;
import org.junit.Assert;
import org.junit.Test;

public class MeetingRoomIIITest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(new boolean[]{true, true}, new MeetingRoomIII().meetingRoomIII(new int[][]{{1,2},{4,5},{8,10}}, 1, new int[][]{{2,3},{3,4}}));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(new boolean[]{false, true}, new MeetingRoomIII().meetingRoomIII(new int[][]{{1,2},{4,5},{8,10}}, 1, new int[][]{{4,5},{5,6}}));
    }

    @Test
    public void testHappyCase3() {
        Assert.assertEquals(new boolean[]{false,true,false,true,false,true,false,false,false,true},
                new MeetingRoomIII().meetingRoomIII(new int[][]{{1,3},{4,6},{6,8},{9,11},{6,9},{1,3},{4,10}}, 3, new int[][]{{1,9},{2,6},{7,9},{3,5},{3,9},{2,4},{7,10},{5,9},{3,10},{9,10}}));
    }

}
