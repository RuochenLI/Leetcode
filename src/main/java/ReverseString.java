/**
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
**/
public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
