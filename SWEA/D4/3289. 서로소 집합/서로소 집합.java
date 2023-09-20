import java.util.Scanner;
 
public class Solution {
    static int[] p;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i; // make-set
            System.out.print("#" + tc + " ");
            for (int i = 0; i < m; i++) {
                int oper = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (oper == 0) union(a, b);
                if (oper == 1) System.out.print(isContain(a, b));
            }
            System.out.println();
        }
    }
     
    static int findSet(int a) { // a의 대표자찾기
        if (a != p[a]) p[a] = findSet(p[a]);
        return p[a];
    }
     
    static void union(int a, int b) { // b를 a에 합치기
        p[findSet(b)] = findSet(a);
    }
     
    static int isContain(int a, int b) {
        if (findSet(a) == findSet(b)) return 1;
        return 0;
    }
}