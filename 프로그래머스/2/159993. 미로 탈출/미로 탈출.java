import java.util.*;

class Solution {
    static int N;
    static int M;
    static char[][] newMap;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        newMap = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            String input = maps[i];
            for (int j = 0; j < M; j++){
                newMap[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (newMap[i][j] == 'S'){
                    answer = bfs(newMap, i, j, 'L');
                }
            }
        }        
        return answer;
    }
    
    static int bfs(char[][] newMap, int r, int c, char target){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {r, c});
        visited[r][c] = true;
        int cnt = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Integer[] pos = queue.poll();
                if (target == 'L' && newMap[pos[0]][pos[1]] == 'L'){
                    visited = new boolean[N][M];
                    int toExit = bfs(newMap, pos[0], pos[1], 'E');
                    if (toExit == -1){
                        return -1;
                    } else {
                        return cnt + toExit;
                    }
                }
                if (target == 'E' && newMap[pos[0]][pos[1]] == 'E'){
                    return cnt;
                }
                int nr, nc;
                for (int j = 0; j < 4; j++){
                    nr = pos[0] + dr[j];
                    nc = pos[1] + dc[j];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M &&
                       newMap[nr][nc] != 'X' && !visited[nr][nc]){
                        queue.add(new Integer[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}