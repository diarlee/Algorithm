import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] primes = new boolean[4000001];
		Arrays.fill(primes, true);
		for (int i = 2; i <= 2000; i++) {
			int num = i;
			if (!primes[i]) continue;
			for (int j = 2; j <= 2000000; j++) {
				num = i * j;
				if (num > 4000000) break;
				primes[num] = false;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		int sum = 0;
		int cnt = 0;
		for (int i = 2; i <= 4000000; i++) {
			if (!primes[i]) continue;

			if (sum == N) {
				cnt++;
			}
			queue.add(i);
			sum += i;
			
			while (sum > N) {
				sum -= queue.poll();
			}
		}
		if (sum == N) cnt++;
		
		System.out.println(cnt);
	}
}