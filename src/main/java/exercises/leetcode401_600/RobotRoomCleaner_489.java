package exercises.leetcode401_600;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

/**
 * 489. Robot Room Cleaner
 */
public class RobotRoomCleaner_489 {
    int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    private void backtrack(final int x, final int y, final int direction) {
        this.robot.clean();
        this.visited.add(new Pair<>(x, y));
        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            int newX = x + directions[newDirection][0];
            int newY = y + directions[newDirection][1];
            if (!visited.contains(new Pair<>(newX, newY)) && this.robot.move()) {
                backtrack(newX, newY, newDirection);
                goBack();
            }
            this.robot.turnRight();
        }
    }

    private void goBack() {
        this.robot.turnRight();
        this.robot.turnRight();
        this.robot.move();
        this.robot.turnRight();
        this.robot.turnRight();
    }

    // This is the robot's control interface.
    // You should not implement it, or speculate about its implementation
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

}
