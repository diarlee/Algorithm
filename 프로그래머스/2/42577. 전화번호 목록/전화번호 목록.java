import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Collections.reverseOrder());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++){
            String number = phone_book[i];
            if (map.get(number) != null) {
                answer = false;
                break;
            }
            String partNum;
            for (int j = 1; j < number.length(); j++){
                partNum = number.substring(0, j);
                map.put(partNum, 1);
            }
        }
        return answer;
    }
}