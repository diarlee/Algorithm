import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	// 완전 이진 트리가 아닐경우 배열로 구현 불가
	// 자식의 인덱스가 반드시 2배가 아니게 되기 때문
	public static class Node {
		int idx;
		String value;
		Node left;
		Node right;
		public Node() {
		}
		public Node(int idx, String value, Node left, Node right) {
			super();
			this.idx = idx;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			List<List<String>> arr = new ArrayList<>(); // list 중첩해서 만든 이차원배열
			for (int i = 0; i < N; i++) { // 입력 전체를 이차원 배열로 받음
				arr.add(Arrays.asList(br.readLine().split(" ")));
			}
			Node node = creNode(arr, arr.get(0)); // 재귀적으로 노드를 만들면서 노드 간 연결
			System.out.println("#" + t + " " + inOrder(N, node));
		}
	}
	public static Node creNode(List<List<String>> arr, List<String> input) { // 재귀적으로 노드를 만들고 연결하는 메서드
		if (input.size() == 4) {
			Node lNode = creNode(arr, arr.get(Integer.parseInt(input.get(2)) - 1));
			Node rNode = creNode(arr, arr.get(Integer.parseInt(input.get(3)) - 1));
			Node newNode = new Node(Integer.parseInt(input.get(0)), input.get(1), lNode, rNode);
			return newNode;
		}
		Node newNode = new Node(Integer.parseInt(input.get(0)), input.get(1), null, null);
		return newNode;
	}
	public static int inOrder(int N, Node node) {
		if (node == null) return 0;
		// 유효한 노드일경우
		int l = inOrder(N, node.left); // L
		int r = inOrder(N, node.right); //R
		if (node.value.equals("+")) return l + r;
		if (node.value.equals("-")) return l - r;
		if (node.value.equals("*")) return l * r;
		if (node.value.equals("/")) return l / r;
		else return Integer.parseInt(node.value);
	}
}