import java.util.*;

public class Solution {

    private Map<Integer, Boolean> map = new HashMap<>();
    public boolean isFascinating(int n) {
        if(!checkZeroContain(n)) {
            return false;
        }

        int doubleN = n*2;
        if(!checkZeroContain(doubleN)) {
            return false;
        }

        int tripleN = n*3;
        if(!checkZeroContain(tripleN)) {
            return false;
        }

        return true;
    }

    private boolean checkZeroContain(int n) {
        if (n == 0) {
            return false;
        }

        int result = n % 10;
        if(map.containsKey(result) || result == 0) {
            return false;
        }
        map.put(result, true);

        result = (n/10) % 10;
        if(map.containsKey(result) || result == 0) {
            return false;
        }
        map.put(result, true);

        result = (n/100) % 10;
        if(map.containsKey(result) || result == 0) {
            return false;
        }
        map.put(result, true);

        return true;
    }

    public int longestSemiRepetitiveSubstring(String s) {
        if(s.length() == 1) {
            return 0;
        }



        return 0;
    }

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        return Collections.emptyList();
    }

    /*
    Input: nums = [-2,0,2], s = "RLL", d = 3
    Output: 8
    Explanation:
    After 1 second, the positions are [-1,-1,1]. Now, the robot at index 0 will move left, and the robot at index 1 will move right.
    After 2 seconds, the positions are [-2,0,0]. Now, the robot at index 1 will move left, and the robot at index 2 will move right.
    After 3 seconds, the positions are [-3,-1,1].
    The distance between the robot at index 0 and 1 is abs(-3 - (-1)) = 2.
    The distance between the robot at index 0 and 2 is abs(-3 - 1) = 4.
    The distance between the robot at index 0 and 1 is abs(-1 - 1) = 2.
    The sum of the pairs of all distances = 2 + 4 + 2 = 8.
     */
    public int sumDistance(int[] nums, String s, int d) {
        int[] move = nums.clone();

        for (int i = 0; i< d; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(s.charAt(j) == 'R')
                    move[j] = move[j] + 1;
                else
                    move[j] = move[j] - 1;
            }
            for(int k = 1; k <= nums.length - 1; k++) {
                if(move[k-1] == move[k]) {
                    char[] charArray = s.toCharArray();
                    charArray[k] = charArray[k] == 'R' ? 'L' : 'R';
                    charArray[k-1] = charArray[k-1] == 'R' ? 'L' : 'R';
                    s = Arrays.toString(charArray).replace(",", "")  //remove the commas
                            .replace("[", "")  //remove the right bracket
                            .replace("]", "")  //remove the left bracket
                            .replace(" ", "")
                            .trim(); //remove trailing spaces from partially initialized arrays
                }
            }
        }
        int distance = 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = j; k < nums.length; k++) {
                if(k == i)
                    continue;
                distance += Math.abs(move[i] - move[k]);
            }
            j++;
        }

        return distance;
    }
}
