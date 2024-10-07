import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++){
            char curChar = name.charAt(i);
            answer += Math.min(curChar - 'A', 26 - (curChar - 'A'));
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A'){
                int endA = i + 1;
                while (endA < name.length() && name.charAt(endA) == 'A') 
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));
                move = Math.min(move, i + (name.length() - endA) * 2);
            }
        }
        answer += move;
        return answer;
    }
}