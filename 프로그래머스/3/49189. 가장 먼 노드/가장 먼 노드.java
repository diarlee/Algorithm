import java.util.*;

class Solution {
    static int[] distance;
    static List<Integer>[] adjList;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++){
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }
        
        bfs(n, 1);
        
        int max = 0;
        for (int i = 1; i <= n; i++){
            max = Math.max(max, distance[i]);
        }
        for (int i = 1; i <= n; i++){
            if (distance[i] == max){
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int n, int start){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {start, 0});
        visited[start] = true;
        while (!queue.isEmpty()){
            Integer[] curNode = queue.poll();
            distance[curNode[0]] = curNode[1];
            for (Integer node : adjList[curNode[0]]){
                if (!visited[node]){
                    queue.add(new Integer[] {node, curNode[1] + 1});
                    visited[node] = true;
                }
            }
        }
    }
}