import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V;
    static int E;
    static List<Integer[]>[] adjList;
    static int[] dist;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Integer[] vw = { v, w };
            adjList[u].add(vw);
        }
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[V + 1];
        dijkstra(start);
        for (int i = 1; i <= V; i++) {
        	if (dist[i] == INF) System.out.println("INF");
        	else System.out.println(dist[i]);
        }
    }

    static void dijkstra(int start) {
        dist[start] = 0;
        for (int i = 1; i <= V; i++) {
            int min = INF;
            int idx = -1;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }
            if (idx == -1) break;
            visited[idx] = true;

            for (int j = 0; j < adjList[idx].size(); j++) {
                if (!visited[adjList[idx].get(j)[0]])
                    dist[adjList[idx].get(j)[0]] = Math.min(dist[adjList[idx].get(j)[0]],
                            dist[idx] + adjList[idx].get(j)[1]);
            }
        }
    }
}