public class LargestPalindromeProduct {

   public int largestPalindrome(int n) {
      if (n == 1) return 9;

      long max = (long) Math.pow(10, n) - 1;
      long min = (long) Math.pow(10, (n - 1));
      long half = max;
      boolean found = false;
      long palindrome = 0;

      while (!found) {
         String nextHalf = new StringBuilder().append(String.valueOf(half)).reverse().toString();
         palindrome = Long.valueOf(String.valueOf(half) + nextHalf);
         long pointer = max;
         while (!found && pointer-- > min) {
            long i = palindrome / pointer;
            if (i > max || i < min) break;

            found = palindrome % pointer == 0;
         }
         half--;
      }

      return (int) (palindrome % 1337);
   }

}
