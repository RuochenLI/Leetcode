package exercises.leetcode601_800;

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        if(num < 10) return num;

        char[] arr = String.valueOf(num).toCharArray();

        int[] rightIndex = new int[10]; // to hold the last index of each digit

        for(int i=0; i<arr.length; i++){
            rightIndex[arr[i] - '0'] = i;  // arr[i] - '0' converts char to num
        }

        for(int i=0; i<arr.length; i++){  // index of present digit we are looking at
            for(int j=9; j>arr[i] - '0'; j--){ // max digit could be 9 and min be GREATER than the present digit we looking at
                if(rightIndex[j] > i){  // if index of 'j' (starts with 9) is greater than present index (basically, is the bigger digit at RIGHT of present digit)
                    // swap and return the answer
                    char temp = arr[i];
                    arr[i] = arr[rightIndex[j]];
                    arr[rightIndex[j]] = temp;
                    return Integer.valueOf(new String(arr)); // return here
                }
            }
        }

        // if we reach till here, that means no swapping is required in the input number.
        return num;
    }
}
