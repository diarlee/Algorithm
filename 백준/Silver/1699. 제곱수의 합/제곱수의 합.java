import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];

        for (int i = 1; i <= 100000; i++) {
        	dp[i] = i;
        	int num = 2;
        	while (Math.pow(num, 2) <= i) {
        		dp[i] = Math.min(dp[i], dp[i - (int) Math.pow(num, 2)] + 1); 
        		num++;
        	}
        }
        
        System.out.println(dp[N]);
    }
}