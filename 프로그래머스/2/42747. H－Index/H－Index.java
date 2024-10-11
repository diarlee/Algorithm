import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length;
        int max = 0;
        for (int i = 0; i < N; i++){
            max = Math.max(max, citations[i]);
        }
        int h = 0;
        while (h <= max){
            int cnt = 0;
            for (int i = 0; i < N; i++){
                if (citations[i] >= h){
                    cnt++;
                }
            }
            if (cnt >= h) {
                answer = Math.max(answer, h);
            }
            h++;
        }
        return answer;
    }
}