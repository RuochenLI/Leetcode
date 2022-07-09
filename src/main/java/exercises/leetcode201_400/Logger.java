package exercises.leetcode201_400;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 */
public class Logger {

    Map<String, Integer> logger;

    public Logger() {
        this.logger = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.logger.containsKey(message) || this.logger.get(message) + 10 <= timestamp) {
            this.logger.put(message, timestamp);
            return true;
        }

        return false;
    }
}
