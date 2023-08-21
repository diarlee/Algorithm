import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 교재 풀이 // 투 포인터
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int st = 1, ed = 1;
		int sum = 1;
		int cnt = 1;
		while (ed != N) {
			if (sum == N) {
				cnt++;
				ed++;
				sum += ed;
			}
			if (sum < N) { // 오른쪽 포인터 이동
				ed++;
				sum += ed;
			}
			if (sum > N) { // 왼쪽 포인터 이동
				sum -= st;
				st++;
			}
		}
		System.out.println(cnt);
	}
}
