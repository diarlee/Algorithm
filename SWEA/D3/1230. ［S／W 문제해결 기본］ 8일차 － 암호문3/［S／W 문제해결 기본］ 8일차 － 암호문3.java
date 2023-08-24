import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) list.addLast(sc.nextInt());
			int num = sc.nextInt(); // 명령문의 개수
			while (num-- > 0) {
				char oper = sc.next().charAt(0);
				if (oper == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) { // s들
						list.add(x++, sc.nextInt());
					}
				}
				if (oper == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				}
				if (oper == 'A') {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.addLast(sc.nextInt());
					}
				}
			}
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}