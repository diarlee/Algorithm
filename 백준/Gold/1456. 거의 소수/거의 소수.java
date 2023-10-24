import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        // B제곱근보다 큰 수의 제곱은 B보다 크므로 B제곱근까지 검사
        int[] nums = new int[(int) Math.sqrt(B) + 1];
        for (int i = 2; i < nums.length; i++) nums[i] = i;

        // 소수 찾기
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < nums.length; i+=2) { // 홀수에서만 찾으면 됨
        	if (nums[i] == 0) continue;
        	int numO = nums[i];
        	primes.add(numO);
        	int num = numO + numO;
        	while (num < nums.length) {
        		nums[num] = 0;
        		num += numO;
        	}
        }
        // 거의 소수 찾기
        int cnt = 0;
        for (int i = 0; i < primes.size(); i++) {
        	long prime = primes.get(i);
        	long primePow = prime;
        	while ((double) prime <= (double) B / (double) primePow) {
        		if ((double) A / (double) primePow <= (double) prime) cnt++;
        		primePow *= prime;
        	}
        }
        System.out.println(cnt);
    }
}