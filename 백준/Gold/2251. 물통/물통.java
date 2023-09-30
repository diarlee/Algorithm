import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int B;
	static int C;
	static boolean[][][] visited;
	static List<Integer> results;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[A + 1][B + 1][C + 1];
		results = new ArrayList<>();
		Integer[] buckets = {0, 0, C};
		bfs(buckets);
		results.sort(null);
		for (int c : results) System.out.println(c);
	}
	
	static void bfs(Integer[] buckets) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(buckets);
		visited[buckets[0]][buckets[1]][buckets[2]] = true;
		while (!queue.isEmpty()) {
			Integer[] curNode = queue.poll();
			if (curNode[0] == 0) results.add(curNode[2]);
			
			Integer[] newNodeAB = {0, curNode[1] + curNode[0], curNode[2]}; // A -> B
			if (newNodeAB[1] > B) {
				newNodeAB[0] = newNodeAB[1] - B;
				newNodeAB[1] = B;
			}
			if (!visited[newNodeAB[0]][newNodeAB[1]][newNodeAB[2]]) {
				queue.add(newNodeAB);
				visited[newNodeAB[0]][newNodeAB[1]][newNodeAB[2]] = true;
			}
			Integer[] newNodeAC = {0, curNode[1], curNode[2] + curNode[0]}; // A -> C
			if (newNodeAC[2] > C) {
				newNodeAC[0] = newNodeAC[2] - C;
				newNodeAC[2] = C;
			}
			if (!visited[newNodeAC[0]][newNodeAC[1]][newNodeAC[2]]) {
				queue.add(newNodeAC);
				visited[newNodeAC[0]][newNodeAC[1]][newNodeAC[2]] = true;
			}
			Integer[] newNodeBC = {curNode[0], 0, curNode[2] + curNode[1]}; // B -> C
			if (newNodeBC[2] > C) {
				newNodeBC[1] = newNodeBC[2] - C;
				newNodeBC[2] = C;
			}
			if (!visited[newNodeBC[0]][newNodeBC[1]][newNodeBC[2]]) {
				queue.add(newNodeBC);
				visited[newNodeBC[0]][newNodeBC[1]][newNodeBC[2]] = true;
			}
			Integer[] newNodeBA = {curNode[0] + curNode[1], 0, curNode[2]}; // B -> A
			if (newNodeBA[0] > A) {
				newNodeBA[1] = newNodeBA[0] - A;
				newNodeBA[0] = A;
			}
			if (!visited[newNodeBA[0]][newNodeBA[1]][newNodeBA[2]]) {
				queue.add(newNodeBA);
				visited[newNodeBA[0]][newNodeBA[1]][newNodeBA[2]] = true;
			}
			Integer[] newNodeCA = {curNode[0] + curNode[2], curNode[1], 0}; // C -> A
			if (newNodeCA[0] > A) {
				newNodeCA[2] = newNodeCA[0] - A;
				newNodeCA[0] = A;
			}
			if (!visited[newNodeCA[0]][newNodeCA[1]][newNodeCA[2]]) {
				queue.add(newNodeCA);
				visited[newNodeCA[0]][newNodeCA[1]][newNodeCA[2]] = true;
			}
			Integer[] newNodeCB = {curNode[0], curNode[1] + curNode[2], 0}; // C -> B
			if (newNodeCB[1] > B) {
				newNodeCB[2] = newNodeCB[1] - B;
				newNodeCB[1] = B;
			}
			if (!visited[newNodeCB[0]][newNodeCB[1]][newNodeCB[2]]) {
				queue.add(newNodeCB);
				visited[newNodeCB[0]][newNodeCB[1]][newNodeCB[2]] = true;
			}
		}
	}
}