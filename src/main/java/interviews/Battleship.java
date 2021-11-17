package interviews;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

class Result {

    private static final int HIT = -1;
    private static final int LOST = -2;
    private static final int SHIP_LENGTH = 3;

    /*
     * Complete the 'play' function below.
     *
     * The function accepts following parameters:
     *  1. STRING playerOneShips
     *  2. STRING_ARRAY playerTwoGuesses
     */

//    public static void play(String playerOneShips, List<String> playerTwoGuesses) {
//
//        String[] playerOneShip = playerOneShips.split(" ");
//        int numberOfShips = playerOneShip.length / 2;
//        System.out.println(String.format("Player One entered %d ships.", numberOfShips));
//        int[][] map = buildMap(playerOneShip, numberOfShips);
//        int numberOfHits = 0;
//        int numberOfTry = Integer.parseInt(playerTwoGuesses.get(0));
//        while (numberOfTry > 0 && numberOfHits != numberOfShips * SHIP_LENGTH) {
//            printMap(map, numberOfTry);
//            String playerTry = playerTwoGuesses.get(numberOfTry + 1);
//            int y = playerTry.charAt(0) - 'A';
//            int x = playerTry.charAt(1) - '1';
//            if (map[y][x] > 0) {
//                map[y][x] = HIT;
//                System.out.println("That was a hit!");
//                numberOfHits++;
//            } else {
//                map[y][x] = LOST;
//                System.out.println("That was a miss!");
//            }
//            numberOfTry--;
//        }
//
//    }
//
//    private static void printMap(final int[][] map, final int numberOfTry) {
//        System.out.println(String.format("Player Two, you have %d guesses left. Board Status:", numberOfTry));
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                switch (map[i][j]) {
//                case HIT:
//                    System.out.print('X');
//                    break;
//                case LOST:
//                    System.out.println('O');
//                    break;
//                default:
//                    System.out.println('.');
//                    break;
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    private static int[][] buildMap(final String[] playerOneShip, final int numberOfShips) {
//        int[][] map = new int[6][6];
//        if (playerOneShip.length % 2 != 0) invalidInput();
//        for (int indexOfShip = 0; indexOfShip < numberOfShips; indexOfShip++) {
//            String start = playerOneShip[indexOfShip * 2];
//            String end = playerOneShip[indexOfShip * 2 + 1];
//            if (start.charAt(0) != end.charAt(0) && start.charAt(1) != end.charAt(1)) invalidInput();
//            int vertical = end.charAt(0) - start.charAt(0) + 1;
//            int horizontal = end.charAt(1) - start.charAt(1) + 1;
//            if (Math.abs(vertical) != 3 || Math.abs(horizontal) != SHIP_LENGTH) invalidInput();
//            for (int i = 0; i < vertical; i++) {
//                for (int j = 0; j < horizontal; j++) {
//                    int y = start.charAt(0) + i - 'A';
//                    int x = start.charAt(1) + j - '1';
//                    if (map[y][x] != 0 ) {
//                        invalidInput();
//                    } else {
//                        map[y][x] = indexOfShip;
//                    }
//                }
//            }
//        }
//        return map;
//    }
//
//    private static void invalidInput() {
//        System.out.println("Invalid");
//        System.exit(-1);
//    }
//
//    public class Battleship {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String playerOneShips = bufferedReader.readLine();
//
//        int playerTwoGuessesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> playerTwoGuesses = IntStream.range(0, playerTwoGuessesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                                                 .collect(toList());
//
//        Result.play(playerOneShips, playerTwoGuesses);
//
//        bufferedReader.close();
//    }
}

