import java.util.*;
import java.io.*;

public class Main {
	static int L;
	static int C;
	static String[] letters;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		letters = new String[C];
		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken();
		}
		Arrays.sort(letters);
		dfs(new Node(0, 0, 0, ""));
	}
	
	static void dfs(Node node) {
		if (node.code.length() == L && node.vCnt >= 1 && node.cCnt >= 2) {
			System.out.println(node.code);
			return;
		}
		if (node.code.length() == L) {
			return;
		}
		int level = node.level;
		for (int i = level; i < C; i++) {
			boolean isVowel;
			if (letters[i].equals("a") || letters[i].equals("e") || letters[i].equals("i") ||
					letters[i].equals("o") || letters[i].equals("u")) {
				node.vCnt++;
				isVowel = true;
			} else {
				node.cCnt++;
				isVowel = false;
			}
			node.code += letters[i];
			node.level = i + 1;
			dfs(node);
			node.level = i - 1;
			node.code = node.code.substring(0, node.code.length() - 1);
			if (isVowel) node.vCnt--;
			else node.cCnt--;
		}
	}
	
	static class Node{
		int vCnt;
		int cCnt;
		int level;
		String code;
		
		public Node(int vCnt, int cCnt, int level, String code) {
			this.vCnt = vCnt;
			this.cCnt = cCnt;
			this.level = level;
			this.code = code;
		}
	}
}