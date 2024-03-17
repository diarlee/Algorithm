import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		if (E == 15) E = 0;
		int S = Integer.parseInt(st.nextToken());
		if (S == 28) S = 0;
		int M = Integer.parseInt(st.nextToken());
		if (M == 19) M = 0;
		
		for (int i = 1; i <= 7980; i++) {
			if (i % 15 == E && i % 28 == S && i % 19 == M) {
				System.out.println(i);
				break;
			}
		}
	}
}