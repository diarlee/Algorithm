import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static String num;
	static String[] primes = {"2", "3", "5" ,"7"};
	static List<Integer> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = "";
		result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			num = primes[i];
			dfs(1);
		}
		for (int i = 0; i < result.size(); i++) System.out.println(result.get(i));
	}
	
	static boolean isPrime(int n) {
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
		if (n % i == 0) return false; // 소수가 아님
		}
	return true; // 소수임
	}
	
	static void dfs(int n) { // n번째 자리까지 검사
		if (n == N) {
			result.add(Integer.parseInt(num));
			num = num.substring(0, n - 1);
			return;
		}
		for (int i = 0; i < 10; i++) {
			num += Integer.toString(i);
			if (isPrime(Integer.parseInt(num))) dfs(n + 1);
			num = num.substring(0, n);
		}
	}
}