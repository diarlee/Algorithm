import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static boolean isMade;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {	
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N + 1];
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				isMade = false;
				if (!visited[i]) {
					visited[i] = true;
					dfs(i, arr[i], 1);
				}
			}
			System.out.println(N - cnt);
		}
	}
	
	static void dfs(int stNode, int curNode, int level) {
		if (stNode == curNode) { // 2인 이상 팀
			isMade = true;
			cnt += level;
			return;
		}
		
		if (visited[curNode]) return;
		
		if (curNode == arr[curNode]) { // 1인 팀
			visited[curNode] = true;
			isMade = true;
			cnt += 1;
			return;
		}
		visited[curNode] = true;
		
		dfs(stNode, arr[curNode], level + 1);
		
		if (!isMade) // 팀이 만들어지지 않은 경우에만 백트래킹
			visited[curNode] = false;
	}
}