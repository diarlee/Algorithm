import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(), K = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            int cnt = 0;
            for (int i = 1; i < (1 << N); i++) { // 부분집합 i룰 체크
            	int partSum = 0;
            	for (int j = 0; j < N; j++) {
            		if ((i & (1 << j)) > 0) {
            			partSum += nums[j];
            		}
            	}
            	if (partSum == K) cnt++;
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}