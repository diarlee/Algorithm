import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0}; // 상좌하우
	static int[] dc = {0, -1, 0, 1};
	static int sharkSize;
	static int eatCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int[] stPos = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					stPos = new int[] {i, j};
				}
			}
		}
		
		sharkSize = 2;
		eatCnt = 0;
		int result = bfs(stPos[0], stPos[1]);
		System.out.println(result);
	}
	
	static int bfs(int r, int c) {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.dis == o2.dis && o1.r == o2.r) {
					return o1.c - o2.c;
				}
				if (o1.dis == o2.dis) {
					return o1.r - o2.r;
				}
				return o1.dis - o2.dis;
			}
		});
		queue.add(new Node(r, c, 0));
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curNode = queue.poll();
				if (map[curNode.r][curNode.c] != 0 && map[curNode.r][curNode.c] < sharkSize) {
					map[curNode.r][curNode.c] = 0; // 이동 후 먹음
					map[r][c] = 0;
					if (++eatCnt == sharkSize) {
						sharkSize++;
						eatCnt = 0;
					}
					return curNode.dis + bfs(curNode.r, curNode.c);
				}
				int nr, nc;
				for (int j = 0; j < 4; j++) {
					nr = curNode.r + dr[j];
					nc = curNode.c + dc[j];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] &&
							map[nr][nc] <= sharkSize) {
						queue.add(new Node(nr, nc, curNode.dis + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return 0;
	}
	
	static class Node{
		int r;
		int c;
		int dis;
		
		public Node(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
}