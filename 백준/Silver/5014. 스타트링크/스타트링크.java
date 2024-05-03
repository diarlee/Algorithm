import java.util.*;
import java.io.*;

public class Main {
	static int F, S, G, U, D;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F + 1];
		int result = bfs();
		if (result == -1) System.out.println("use the stairs");
		else System.out.println(result);
	}
	
	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(S, 0));
		visited[S] = true;
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			if (curNode.floor == G) {
				return curNode.cnt;
			}
			if (U != 0 && curNode.floor + U <= F && !visited[curNode.floor + U]) {
				queue.add(new Node(curNode.floor + U, curNode.cnt + 1));
				visited[curNode.floor + U] = true;
			}
			if (D != 0 && curNode.floor - D >= 1 && !visited[curNode.floor - D] ) {
				queue.add(new Node(curNode.floor - D, curNode.cnt + 1));
				visited[curNode.floor - D] = true;
			}
		}
		return -1;
	}
	
	static class Node{
		int floor;
		int cnt;
		
		public Node(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}
}