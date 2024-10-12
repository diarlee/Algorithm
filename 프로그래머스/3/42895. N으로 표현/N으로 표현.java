import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        Map<Integer, Boolean>[] maps = new HashMap[9];
        for (int i = 1; i <= 8; i++){
            maps[i] = new HashMap<>();
        }
        
        if (N == number){
            answer = 1;
            return answer;
        }
        maps[1].put(N, true);
        for (int i = 2; i <= 8; i++){
            int conN = getConN(N, i);
            if (conN == number){
                answer = i;
                return answer;
            }
            maps[i].put(conN, true);
            for (int j = 1; j <= i / 2; j++){
                for (Integer key1 : maps[j].keySet()){
                    for (Integer key2 : maps[i - j].keySet()){
                        int num1 = key1 + key2;
                        int num2 = key1 - key2;
                        int num3 = key2 - key1;
                        int num4 = key1 * key2;
                        if (key2 != 0){
                            int num5 = key1 / key2;
                            if (num5 == number){
                                answer = i;
                                return answer;
                            }
                            maps[i].put(num5, true);
                        }
                        if (key1 != 0){
                            int num6 = key2 / key1;
                            if (num6 == number){
                                answer = i;
                                return answer;
                            }
                            maps[i].put(num6, true);
                        }
                        if (num1 == number || num2 == number || 
                           num3 == number || num4 == number){
                            answer = i;
                            return answer;
                        }
                        maps[i].put(num1, true);
                        maps[i].put(num2, true);
                        maps[i].put(num3, true);
                        maps[i].put(num4, true);
                    }
                }
            }
        }
        return -1;
    }
    
    static int getConN(int N, int idx){
        int conN = 0;
        for (int i = 0; i < idx; i++){
            conN += N * Math.pow(10, i);
        }
        return conN;
    }
}