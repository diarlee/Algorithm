import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] adjList;
	static int cnt;
	static int delete;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1) {
				root = i;
				continue;
			}
			adjList[p].add(i);
		}
		delete = Integer.parseInt(br.readLine());
		cnt = 0;
		if (delete != root) dfs(-1, root);
		System.out.println(cnt);
	}
	
	static void dfs(int pNode, int curNode) {
		if (curNode == delete) {
			if (adjList[pNode].size() == 1) cnt++;
			return;
		}
		if (adjList[curNode].size() == 0) cnt++;
		for (int i : adjList[curNode]) dfs(curNode, i);
	}
}