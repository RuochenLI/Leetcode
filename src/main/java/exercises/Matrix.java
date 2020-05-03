package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 * Created by Ruochen on 19/03/2017.
 */
public class Matrix {
    int[][] valueMatrix;

    private void init(int x, int y) {
        valueMatrix = new int[x][y];
        for (int i = 0; i < x; i ++) {
            Arrays.fill(valueMatrix[i], Integer.MAX_VALUE);
        }
    }

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int x = matrix.size();
        int y = matrix.get(0).size();

        init(x, y);
        calculateValueMatrix(matrix, x, y, 1);
        calculateValueMatrix(matrix, x, y, -1);
        return transform();
    }

    private void calculateValueMatrix(List<List<Integer>> matrix, int x, int y, int direction) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix.get(i).get(j) != 0) {
                    valueMatrix[i][j] = Math.min(Math.min(getValue(i + direction, j, matrix, direction), getValue(i, j + direction, matrix, direction)), valueMatrix[i][j]);
                } else {
                    valueMatrix[i][j] = 0;
                }
            }
        }
    }

    private List<List<Integer>> transform() {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] aValueMatrix : valueMatrix) {
            List<Integer> line = new ArrayList<>();
            for (int anAValueMatrix : aValueMatrix) {
                line.add(anAValueMatrix);
            }
            result.add(line);
        }
        return result;
    }

    int getValue(int line, int col, List<List<Integer>> matrix, int direction) {
        if (line < 0 || col < 0 || line >= matrix.size() || col >= matrix.get(0).size()) {
            return Integer.MAX_VALUE;
        }
        if (matrix.get(line).get(col) == 0) {
            return 1;
        }
        if (valueMatrix[line][col] != Integer.MAX_VALUE) {
            return valueMatrix[line][col] + 1;
        }
        int getValue = Math.min(getValue(line + direction, col, matrix, direction), getValue(line, col + direction, matrix, direction));
        return getValue != Integer.MAX_VALUE ? getValue + 1 : Integer.MAX_VALUE;
    }
}
