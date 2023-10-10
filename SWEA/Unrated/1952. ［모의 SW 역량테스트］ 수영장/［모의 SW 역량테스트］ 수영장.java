import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int day = sc.nextInt();
            int month = sc.nextInt();
            int threeM = sc.nextInt();
            int year = sc.nextInt();
            int[] plan = new int[13]; // i달까지의 최소 비용
            for (int i = 1; i <= 12; i++) { 
                int cnt = sc.nextInt();
                if (cnt == 0) plan[i] = plan[i - 1];
                else {
                	plan[i] = plan[i - 1] + Math.min(day * cnt, month); // 일일권, 한 달권 비교
                	if (i >= 3) plan[i] = Math.min(plan[i], plan[i - 3] + threeM); // 세 달권 비교
                }
                if (i == 12) plan[i] = Math.min(plan[i], year); // 일 년권 비교
            }
            System.out.println("#" + tc + " " + plan[12]);
        }
    }
}