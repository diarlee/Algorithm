import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static class Node {
		int idx;
		Node parent;
		Node left;
		Node right;
		int level;
		public Node() {
		}
		public Node(int idx, Node parent, Node left, Node right, int level) {
			super();
			this.idx = idx;
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.level = level;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int V = Integer.parseInt(input[0]), E = Integer.parseInt(input[1]);
			int num1 = Integer.parseInt(input[2]), num2 = Integer.parseInt(input[3]);
			String[] _tmp = br.readLine().split(" "); 
			List<Integer[]> arr = new ArrayList<>(); // 간선 정보
			for (int i = 0; i < _tmp.length; i+=2) {
				Integer[] row = new Integer[2];
				row[0] = Integer.parseInt(_tmp[i]);
				row[1] = Integer.parseInt(_tmp[i + 1]);
				arr.add(row);
			}
			Node tree = creNode(arr, 1, null, 0); // 1부터 끝까지 연결되어 있는 트리
			Node node1 = getNode(tree, num1); // 값이 num1인 노드
			Node node2 = getNode(tree, num2); // 값이 num2인 노드
			while (node1 != node2) { // 부모 같아질때까지 위로 탐색
				if (node1.level > node2.level) node1 = node1.parent; // node1이 더 밑에 있음 // node1 올림
				if (node1.level < node2.level) node2 = node2.parent; // node2가 더 밑에 있음 // node2 올림
				if (node1.level == node2.level) {
					node1 = node1.parent;
					node2 = node2.parent;
				}
			}
			int subTreeSize = getTreeSize(node1); // node1 = node2 : 가장 가까운 공통 조상
			System.out.println("#" + t + " " + node1.idx + " " + subTreeSize);
		}
	}
    
	public static Node creNode(List<Integer[]> arr, int idx, Node parent, int level) { // 재귀적으로 트리 만들기
		Node newNode = new Node(idx, parent, null, null, level);
		int cnt = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i)[0] == idx && cnt == 0) { // lchild 존재
				int l_idx = arr.get(i)[1];
				cnt++;
				newNode.left = creNode(arr, l_idx, newNode, level + 1);
			} else if (arr.get(i)[0] == idx && cnt == 1) { // rchild 존재
				int r_idx = arr.get(i)[1];
				cnt++;
				newNode.right = creNode(arr, r_idx, newNode, level + 1);
				break;
			}
		}
		return newNode;
	}
	
	public static Node getNode(Node node, int idx) { // 찾고자 하는 노드만 반환
		if (node == null) return null;
		if (node.idx == idx) return node;
		Node lNode = getNode(node.left, idx); // L
		Node rNode = getNode(node.right, idx); //R
		if (lNode != null) return lNode;
		if (rNode != null) return rNode;
		return null;
	}
	
	public static int getTreeSize(Node node) {
		if (node == null) return 0;
		int cnt = 1;
		int lCnt = getTreeSize(node.left); // L
		int rCnt = getTreeSize(node.right); //R
		return cnt + lCnt + rCnt;
	}
}