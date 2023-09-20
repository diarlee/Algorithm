import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Solution {
    static int[] p;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            p = new int[N + 1];
            for (int i = 1; i <= N; i++) p[i] = i; // make-set
            for (int i = 0; i < M; i++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                union(p1, p2);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                findSet(i);
            }
            for (int i = 1; i <= N; i++) set.add(p[i]);
            System.out.println("#" + tc + " " + set.size());
        }
    }
     
    static int findSet(int a) {
        if (p[a] != a) p[a] = findSet(p[a]);
        return p[a];
    }
     
    static void union(int a, int b) {
        p[findSet(b)] = p[findSet(a)];
    }
}