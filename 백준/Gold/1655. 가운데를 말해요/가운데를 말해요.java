import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqLeft = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqRight = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (i == 0) {
				pqLeft.add(num);
			}
			else if (i == 1 && pqLeft.peek() <= num) {
				pqRight.add(num);
			}
			else if (i == 1 && pqLeft.peek() > num) {
				pqRight.add(pqLeft.poll());
				pqLeft.add(num);
			} else {
				if (pqLeft.size() == pqRight.size()) {
					if (num <= pqRight.peek()) {
						pqLeft.add(num);
					} else {
						pqLeft.add(pqRight.poll());
						pqRight.add(num);
					}
				} else {
					if (num < pqLeft.peek()) {
						pqRight.add(pqLeft.poll());
						pqLeft.add(num);
					} else {
						pqRight.add(num);
					}
				}
			}
			System.out.println(pqLeft.peek());
		}
	}
}