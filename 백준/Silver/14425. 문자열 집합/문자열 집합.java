import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static Node tree;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new Node();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			makeTree(str);
		} // 입력 완료
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			findStr(str);
		}
		System.out.println(cnt);
	}
	
	static void makeTree(String str) {
		Node curNode = tree;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (curNode.nextItems[c - 'a'] == null) {
				curNode.nextItems[c - 'a'] = new Node(c);
			}
			curNode = curNode.nextItems[c - 'a'];
		}
		curNode.isEnd = true;
	}
	
	static void findStr(String str) {
		Node curNode = tree;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (curNode.nextItems[c - 'a'] == null) return;
			curNode = curNode.nextItems[c - 'a'];
		}
		if (curNode.isEnd) cnt++;
	}
}

class Node {
	char curItem;
	Node[] nextItems = new Node[26];
	boolean isEnd;
	public Node(char curItem) {
		this.curItem = curItem;
	}
	public Node() {
	}
}