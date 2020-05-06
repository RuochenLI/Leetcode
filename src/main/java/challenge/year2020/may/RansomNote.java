package challenge.year2020.may;

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class RansomNote {

    /*
    126 / 126 test cases passed.
    Status: Accepted
    Runtime: 6 ms
    Memory Usage: 39.7 MB
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine.contains(ransomNote)) {
            return true;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        char[] ransomNoteCharArray = ransomNote.toCharArray();
        char[] magazineCharArray = magazine.toCharArray();

        Map<Character, Integer> ransomMap = new HashMap<>();
        for (final char c : ransomNoteCharArray) {
            ransomMap.compute(c, (key, val) -> (val == null ? 1 : val +1));
        }

        int magazinePointer = 0;

        while (!ransomMap.isEmpty() && magazinePointer < magazineCharArray.length) {
            char current = magazineCharArray[magazinePointer++];
            if (ransomMap.containsKey(current) && ransomMap.get(current) == 1) {
                ransomMap.remove(current);
            }
            ransomMap.computeIfPresent(current, (key, val) -> (val - 1));
        }

        return ransomMap.isEmpty();
    }

    /*
    126 / 126 test cases passed.
    Status: Accepted
    Runtime: 31 ms
    Memory Usage: 40.2 MB
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.contains(ransomNote)) {
            return true;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        char[] magazineCharArray = magazine.toCharArray();
        int magazinePointer = 0;

        List<Character> ransomNoteList = ransomNote.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        while (!ransomNoteList.isEmpty() && magazinePointer < magazineCharArray.length) {
            Character current = magazineCharArray[magazinePointer++];
            int index = ransomNoteList.indexOf(current);
            if (index >= 0) {
                ransomNoteList.remove(index);
            }
        }
        return ransomNoteList.isEmpty();
    }
}
