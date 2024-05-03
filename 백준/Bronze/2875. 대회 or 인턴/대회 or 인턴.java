import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
		K = Integer.parseInt(st.nextToken());
		
		while (K > 0) {
			if (2 * M > N) {
				M--;
				K--;
			} else {
				N--;
				K--;
			}
		}
		
		int cnt = 0;
		while (N > 1 && M > 0) {
			N -= 2;
			M -= 1;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}