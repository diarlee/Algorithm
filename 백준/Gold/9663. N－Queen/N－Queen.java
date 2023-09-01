import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] arr;
    public static int[] dr = {-1, -1, -1}; // 좌상 상 우상
    public static int[] dc = {-1, 0, 1};
    public static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        cnt = 0;
        findQueenArr(0);
        System.out.println(cnt);
    }

    public static void findQueenArr(int r) {
        if (r == N) { // r이 N이 되면 카운트  & c가 N이 되면  이전 행으로 돌아감
            cnt++;
            return;
        }

        for (int c = 0; c < N; c++) { // r행에서 queen 자리 찾기
            if (queenMate(r, c) == false) { // (r, c)에 퀸을 놓을 수 있으면 queenMate(r + 1, c) 다음 행 탐색
                arr[r][c] = 1;
                findQueenArr(r + 1);
                arr[r][c] = 0;
            }
            // (r, c)에 퀸을 놓을 수 없으면 다음 열 (r, c + 1) 탐색
        }
    }

    public static boolean queenMate(int r, int c) { // (r, c)에 queen 놓을 수 있는지 판단
        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            while (0 <= nr && 0 <= nc && nc < N) {
                if (arr[nr][nc] == 1) return true; // queen 놓을 수 없음
                nr += dr[d];
                nc += dc[d];
            }
        }
        return false; // queen 놓을 수 있음
    }
}