import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt(); // M초의 시간에 K개의 붕어빵 만듦
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				priorityQueue.add(sc.nextInt());
			}
			String ans = "Possible";
			int sec = 0;
			int inCnt = 0;
			int outCnt = 0;
			while (!priorityQueue.isEmpty()) {
				sec = priorityQueue.poll(); // 손님 오는 시간
				inCnt = (sec / M) * K; // 만들어진 빵의 개수
				if (inCnt - outCnt <= 0) { 
					ans = "Impossible";
					break;
				}
				outCnt++; // 손님이 빵 가져감
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}