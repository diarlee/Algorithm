import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) list.addLast(sc.nextInt());
			int num = sc.nextInt();
			while (num-- > 0) {
				sc.next(); // 명령어 ㅣ
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = 0; j < y; j++) { // s들
					list.add(x++, sc.nextInt());
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