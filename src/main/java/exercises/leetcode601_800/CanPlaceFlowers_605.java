package exercises.leetcode601_800;

public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pointer = 0;
        while (pointer < flowerbed.length && flowerbed[pointer] == 0) { pointer++; }
        if (pointer < flowerbed.length) {
            n -= pointer / 2;
        } else {
            n--;
            pointer = 0;
        }
        if (n <= 0) return true;
        pointer += 2;
        while (pointer < flowerbed.length) {
            if (flowerbed[pointer] == 0) {
                if (pointer == flowerbed.length - 1 || flowerbed[pointer + 1] == 0) {
                    n--;
                    if (n == 0) return true;
                    pointer += 2;
                } else {
                    pointer++;
                }
            } else {
                pointer += 2;
            }
        }
        return false;
    }
}
