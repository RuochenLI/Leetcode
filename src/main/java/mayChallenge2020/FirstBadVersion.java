package mayChallenge2020;

public class FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        /*
        You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

        You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

        Example:

        Given n = 5, and version = 4 is the first bad version.

        call isBadVersion(3) -> false
        call isBadVersion(5) -> true
        call isBadVersion(4) -> true

        Then 4 is the first bad version.
         */
        public int firstBadVersion1(int n) {
            return findBadVersion(1, n);
        }

        public int findBadVersion(int start, int end) {
            if (start == end) {
                return start;
            }

            int medium = (end + start) / 2;
            if (isBadVersion(medium)) {
                return findBadVersion(start, medium);
            }

            return findBadVersion(medium + 1, end);
        }

        public int firstBadVersion2(int n) {
            int start = 1;
            int end = n;
            while (start < end) {
                int medium = start + (end - start) / 2;
                if (isBadVersion(medium)) {
                    end = medium;
                } else {
                    start = medium + 1;
                }
            }
            return start;
        }
    }

    class VersionControl {
        boolean isBadVersion(int version){
            return false; //fake
        }
    }
}
