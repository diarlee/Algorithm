import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            char[][] arr = new char[N + 4][N + 4];
            for (int i = 2; i < N + 2; i++) {
                char[] row = sc.next().toCharArray(); // 문자열을 한 글자씩 나눠 char타입   배열에 반환
                for (int j = 2; j < N + 2; j++) {
                    arr[i][j] = row[j - 2];
                }
            }
            int check = 0;
            outter: for (int i = 2; i < N + 2; i++) {
                for (int j = 2; j < N + 2; j++) {
                    if (arr[i][j - 2] == 'o' && arr[i][j - 1] == 'o' && arr[i][j] == 'o' && arr[i][j + 1] == 'o'
                            && arr[i][j + 2] == 'o') { // 가로 탐색
                        check = 1;
                        break outter;
                    }
                    if (arr[i - 2][j] == 'o' && arr[i - 1][j] == 'o' && arr[i][j] == 'o' && arr[i + 1][j] == 'o'
                            && arr[i + 2][j] == 'o') { // 세로 탐색
                        check = 1;
                        break outter;
                    }
                    if (arr[i - 2][j - 2] == 'o' && arr[i - 1][j - 1] == 'o' && arr[i][j] == 'o'
                            && arr[i + 1][j + 1] == 'o' && arr[i + 2][j + 2] == 'o') { // 대각선1 탐색
                        check = 1;
                        break outter;
                    }
                    if (arr[i + 2][j - 2] == 'o' && arr[i + 1][j - 1] == 'o' && arr[i][j] == 'o'
                            && arr[i - 1][j + 1] == 'o' && arr[i - 2][j + 2] == 'o') { // 대각선2 탐색
                        check = 1;
                        break outter;
                    }
                }
            }
            if (check == 1) System.out.println("#" + test_case + " " + "YES");
            else System.out.println("#" + test_case + " " + "NO");
        }
    }
}