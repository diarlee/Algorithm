import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		Integer[][] map = new Integer[3][3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 0;
		int answer = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == 0) {
					answer = bfs(map, idx);
				}
				idx++;
			}
		}
		
		System.out.println(answer);
	}
	
	static int bfs(Integer[][] map, int idx) {
		Map<String, Boolean> hashMap = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(mapToStr(map), idx, 0); 
		queue.add(start);
		hashMap.put(start.sequence, true);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curNode = queue.poll();
				if (isClear(curNode.sequence)) return curNode.cnt;
				int[] nearPos = getNearPos(curNode.idx);
				for (int j = 0; j < nearPos.length; j++) {
					char[] arr = curNode.sequence.toCharArray();
					char tmp = arr[nearPos[j]];
					arr[nearPos[j]] = '0';
					arr[curNode.idx] = tmp;
					String newSeq = String.valueOf(arr);
					if (hashMap.get(newSeq) == null) {
						queue.add(new Node(newSeq, nearPos[j], curNode.cnt + 1));
						hashMap.put(newSeq, true);
					}
				}
			}
		}
		return -1;
	}
	
	static class Node{
		String sequence;
		int idx;
		int cnt;
		
		public Node(String sequence, int idx, int cnt) {
			this.sequence = sequence;
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	
	static String mapToStr(Integer[][] map) {
		String key = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				key += String.valueOf(map[i][j]);
			}
		}
		return key;
	}
	
	static boolean isClear(String sequence) {
		int idx = 1;
		for (int i = 0; i < 8; i++) {
			if (sequence.charAt(i) - '0' != idx++) {
				return false;
			}
		}
		return true;
	}
	
	static int[] getNearPos(int idx) {
		int[] nearPos = {};
		switch (idx) {
		case 0 : nearPos = new int[] {1, 3}; break;
		case 1 : nearPos = new int[] {0, 4, 2}; break;
		case 2 : nearPos = new int[] {1, 5}; break;
		case 3 : nearPos = new int[] {0, 4, 6}; break;
		case 4 : nearPos = new int[] {1, 3, 5, 7}; break;
		case 5 : nearPos = new int[] {2, 4, 8}; break;
		case 6 : nearPos = new int[] {3, 7}; break;
		case 7 : nearPos = new int[] {4, 6, 8}; break;
		case 8 : nearPos = new int[] {5, 7}; break;
		}
		return nearPos;
	}
}