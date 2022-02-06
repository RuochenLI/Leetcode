package interviews.google;

import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                int leftAsteroid = 0;

                while (!stack.empty() && leftAsteroid < Math.abs(asteroid) && leftAsteroid >= 0) {
                    leftAsteroid = stack.pop();
                }
                if (leftAsteroid < 0) {
                    stack.push(leftAsteroid);
                    stack.push(asteroid);
                    continue;
                }

                if (leftAsteroid < Math.abs(asteroid)) {
                    stack.push(asteroid);
                    continue;
                }

                if (leftAsteroid > Math.abs(asteroid)) {
                    stack.push(leftAsteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }

}
