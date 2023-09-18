import java.util.Scanner;
 
public class Solution {
    public static int N;
    public static int M;
    public static int[][] adjArr;
    public static int cnt; // 정점 수 count
    public static int[] visited; // visited : 이미 탐색한 정점
    public static int max;
     
    public static void isPath(int a) { // a : 탐색 시작정점
    	visited[a] = 1; // 방문처리
        cnt++;
        if (cnt == N) { // 모든 정점 방문함
            max = cnt;
            cnt--;
            visited[a] = 0;
            return;
        }
        for (int j = 1; j < N + 1; j++) { // a 정점의 간선들 탐색
            if (adjArr[a][j] == 1 && visited[j] == 0) { // 방문하지 않은 간선이 있으면
                isPath(j);
            }
        }
        // 더 이상 탐색할 정점이 없음
        if (cnt > max) max = cnt;
        cnt--;
        visited[a] = 0;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            adjArr = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adjArr[x][y] = 1;
                adjArr[y][x] = 1;
            }
            max = 0;
            if (N == 1) max = 1;
            else {
                for (int i = 1; i < N + 1; i++) { // i 정점에서 N 정점까지 탐색 
                	cnt = 0;
                	visited = new int[N + 1];
                	isPath(i);
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}