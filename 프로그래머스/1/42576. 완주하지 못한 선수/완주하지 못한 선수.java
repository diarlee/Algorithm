import java.util.*;
    
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < completion.length; i++){
            String person = completion[i];
            if (hash.get(person) == null){
                hash.put(person, 1);
            } else {
                hash.put(person, hash.get(person) + 1);
            }
        }
        for (int i = 0; i < participant.length; i++){
            String person = participant[i];
            if (hash.get(person) != null && hash.get(person) > 0){
                hash.put(person, hash.get(person) - 1);
            } else {
                answer = person;
                break;
            }
        }
        return answer;
    }
}