import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map; // 0 : 아무것도 없음, 1 : 뱀, 2 : 사과
	static char[] switches = new char[10001];
	static int[] dr = {0, 1, 0, -1}; // 우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int len;
	static int tailD; 
	static Queue<Node> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			switches[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		
		map[1][1] = 1;
		len = 1;
		tailD = 0;
		queue = new LinkedList<>();
		move(1, 1, 1, 1, 0, 1);
	}
	
	// [hr][hc] : 뱀의 머리 위치, [tr][tc] : 뱀의 꼬리 위치, s : s초 시작
	static void move(int hr, int hc, int tr, int tc, int d, int s) { 
		hr += dr[d];
		hc += dc[d];
		if (hr <= 0 || hr >= N + 1 || hc <= 0 || hc >= N + 1 || map[hr][hc] == 1) {
			System.out.println(s);
			return;
		}
		
		if (map[hr][hc] == 2) { // 사과가 있을 때
			map[hr][hc] = 1;
			len++;
		}
		
		if (map[hr][hc] == 0) { // 사과가 없을 때
			map[hr][hc] = 1;
			map[tr][tc] = 0;
			tr += dr[tailD];
			tc += dc[tailD];
		}
		
		// 머리 방향전환
		if (switches[s] == 'L') {
			d = d - 1 >= 0 ? d - 1 : 3;
			queue.add(new Node(hr, hc, d));
		} else if (switches[s] == 'D') {
			d = d == 3 ? 0 : d + 1;
			queue.add(new Node(hr, hc, d));
		}
		
		
		// 꼬리 방향전환
		if (queue.size() != 0 && queue.peek().r == tr && queue.peek().c == tc) {
			tailD = queue.poll().dir;
		}
		
		move(hr, hc, tr, tc, d, s + 1);
	}
	
	static class Node {
		int r;
		int c;
		int dir;
		
		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}