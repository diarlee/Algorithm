import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        System.out.println(s);
        for (int i = 0; i < arr.length; i++){
            String tmp = "";
            String str = arr[i];
            for (int j = 0; j < str.length(); j++){
                // 첫 글자가 숫자인 경우
                if (j == 0 && str.charAt(j) - 'A' < 0){
                    tmp += str.charAt(j);
                }
                // 첫 글자가 소문자인 경우
                else if (j == 0 && str.charAt(j) - 'a' >= 0){
                    tmp += (char) (str.charAt(j) - 32);
                }
                // 첫 글자가 아닌데 대문자인 경우
                else if (j != 0 && str.charAt(j) - 'a' < 0) {
                    tmp += (char) (str.charAt(j) + 32);
                }
                else {
                    tmp += str.charAt(j);
                }
            }
            arr[i] = tmp;
        }
        String answer = "";
        for (int i = 0; i < arr.length; i++){
            answer += arr[i];
            if (i == arr.length - 1 && 
                !s.substring(s.length()-1, s.length()).equals(" ")){
                break;
            }
            answer += " ";
        }
        return answer;
    }
}