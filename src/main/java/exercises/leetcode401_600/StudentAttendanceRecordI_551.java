package exercises.leetcode401_600;

/**
 * 551. Student Attendance Record I
 */
public class StudentAttendanceRecordI_551 {
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count++;
                if (count >= 2) return false;
            }
        }

        return true;
    }
}
