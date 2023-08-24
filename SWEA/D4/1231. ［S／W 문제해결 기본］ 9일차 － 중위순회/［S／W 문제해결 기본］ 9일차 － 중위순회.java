import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N + 1]; // 배열로 tree 만들기
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int idx = Integer.parseInt(input[0]);
                String value = input[1];
                arr[idx] = value;
            }
            System.out.print("#" + t + " ");
            inOrder(N, arr, 1);
            System.out.println();
        }
         
    } public static void inOrder(int N, String[] arr, int i) {
        if (i <= N) { // 유효한 노드인지 검사
            inOrder(N, arr, i * 2); // L
            System.out.print(arr[i]); // V
            inOrder(N, arr, i * 2 + 1); //R
        }
    }
}