import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int c = 0; c < commands.length; c++){
            int i = commands[c][0] - 1;
            int j = commands[c][1] - 1;
            int k = commands[c][2] - 1;
            int len = j - i + 1;
            int[] newArr = new int[len];
            for (int l = 0; l < len; l++){
                newArr[l] = array[i + l];
            }
            Arrays.sort(newArr);
            answer[c] = newArr[k];
        }
        return answer;
    }
}