import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
    for (int test_case = 1; test_case <= T; test_case++) {
        sc.nextInt();
        int[][] arr = new int[101][102];
        for (int i = 0; i < 100; i++) { // 입력받음
            for (int j = 1; j < 101; j++) { // 좌 우 하 한줄씩 더
                arr[i][j] = sc.nextInt();
            }
        }
        for (int x = 1; x < 101; x++) {
            if (arr[0][x] == 0) continue; // 출발점 고르기
            int[][] arrCopy = new int[101][102];
            for (int i = 0; i < 100; i++) // 출발점마다 사다리 reset
                arrCopy[i] = arr[i].clone();
            int i = 0;
            int j = x;
            while (i < 100) {
//              System.out.println(i + " " + j);
                // 좌 -> 우 -> 하 탐색
                // 지나간 위치는 0으로 변환
                // 현재위치 [i][j]
                if (i == 99) break;
                 
                if (arrCopy[i][j - 1] == 1) { // 좌
                    arrCopy[i][j] = 0;
                    j--;
                }
                else if (arrCopy[i][j + 1] == 1) { // 우
                    arrCopy[i][j] = 0;
                    j++; // 우
                }
                else  { // 하 // (arr[i + 1][j] == 1)
                    arrCopy[i][j] = 0;
                    i++;
                }
            }
            if (arrCopy[i][j] == 2) {
                System.out.println("#" + test_case + " " + (x - 1));
                break;
            }
        }
    }
}
}