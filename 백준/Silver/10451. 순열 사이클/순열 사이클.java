import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] perm;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			perm = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1 ; i <= N; i++) {
				perm[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N + 1];
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) recur(i, perm[i]);
			}
			System.out.println(cnt);
		}
		
	}
	
	static void recur(int stNode, int curNode) {
		if (perm[curNode] == stNode) {
			visited[curNode] = true;
			cnt++;
		}
		if (!visited[curNode]) {
			visited[curNode] = true;
			recur(stNode, perm[curNode]);
		}
	}
}