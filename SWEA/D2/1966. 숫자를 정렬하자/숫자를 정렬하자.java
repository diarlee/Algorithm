import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				priorityQueue.add(sc.nextInt());
			}
			System.out.print("#" + t);
			while (!priorityQueue.isEmpty()) {
				System.out.print(" " + priorityQueue.poll());
			}
			System.out.println();
		}
	}
}