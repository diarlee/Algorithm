import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));
		int sum = 0;
		int cards1;
		int cards2;
		while (pq.size() != 1) {
			cards1 = pq.poll();
			cards2 = pq.poll();
			sum += cards1 + cards2;
			pq.offer(cards1 + cards2);
		}
		System.out.println(sum);
	}
}