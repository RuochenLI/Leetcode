package challenge.year2020.may;

import java.util.HashSet;
import java.util.Set;

import exercises.RedundantConnection;
import org.junit.Assert;
import org.junit.Test;

public class RedundantConnectionTest {

    @Test
    public void testCase1() {
        int[][] input = {{1,4},{3,4},{1,3},{1,2},{4,5}};
        int[] expected = {1,3};
        int[] actual = new RedundantConnection().findRedundantConnection(input);
        Assert.assertEquals(actual, expected);
    }


    class Solution {

        public int[] findRedundantConnection(int[][] edges) {
            int[] edgeToReturn = null;
            Set<Integer> visited = new HashSet<>();
            for (int[] edge : edges) {
                if(visited.contains(edge[0]) && visited.contains(edge[1])) {
                    edgeToReturn = edge;
                }
                visited.add(edge[0]);
                visited.add(edge[1]);
            }

            return edgeToReturn;
        }
    }
}
