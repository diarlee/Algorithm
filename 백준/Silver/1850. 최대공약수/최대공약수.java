import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		Long max = Math.max(A, B);
		Long min = Math.min(A, B);
		Long remainder = max % min;
		while (remainder != 0) {
			max = min;
			min = remainder;
			remainder = max % min;
		}
		
		String result = "1";
		System.out.println(result.repeat(min.intValue()));
	}
}