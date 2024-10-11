class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(n, computers, i);
                answer++;
            }
        }         
        return answer;
    }
    
    static void dfs(int n, int[][] computers, int com){
        visited[com] = true;
        for (int i = 0; i < n; i++){
            if (com == i) continue;
            if (computers[com][i] == 1 && !visited[i]){
                dfs(n, computers, i);
            }
        }
    }
}