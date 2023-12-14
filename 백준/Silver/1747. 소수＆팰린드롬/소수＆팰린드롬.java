import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] primes = new int[20000001];
		for (int i = 1; i <= 2000000; i++) {
			primes[i] = i;
		}
		primes[1] = 0;
		for (int i = 2; i <= Math.sqrt(2000000); i++) {
			if (primes[i] != 0) {
				int k = 2000000 / i;
				for (int j = 2; j <= k; j++) {
					primes[i * j] = 0;
				}
			}
		}
		for (int i = N; i <= 2000000; i++) {
			if (primes[i] != 0) {
				String num = String.valueOf(primes[i]);
				int len = num.length();
				boolean check = true;
				for (int j = 0; j < len; j++) {
					if (num.charAt(j) != num.charAt(len - 1 - j)) {
						check = false;
						break;
					}
				}
				if (check == true) {
					System.out.println(primes[i]);
					break;
				}
			}
		}
	}
}