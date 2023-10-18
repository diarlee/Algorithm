import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] people;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        people = new int[N + 1]; // 각 사람의 부모 저장
        boolean[] known = new boolean[N + 1]; // 각 사람이 진실을 아는지 저장
        int[] party = new int[M]; // 각 파티의 대표자들(가장 낮은 번호) 저장
        
        for (int i = 1; i <= N; i++)
            people[i] = i;
        
        st = new StringTokenizer(br.readLine());
        int kCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < kCnt; i++)
            known[Integer.parseInt(st.nextToken())] = true;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pCnt = Integer.parseInt(st.nextToken());
            party[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < pCnt; j++) {
                int person = Integer.parseInt(st.nextToken());
                union(party[i], person);
            }
        }
        
        for (int i = 1; i <= N; i++) {
        	if (known[i]) known[findSet(i)] = true;
        	if (known[findSet(i)]) known[i] = true;
        }
        
        for (int i = N; i >= 0; i--) {
        	if (known[i]) known[findSet(i)] = true;
        	if (known[findSet(i)]) known[i] = true;
        }
        
        int cnt = 0;
        for (int i = 0; i < M; i++) {
        	if (!known[party[i]]) cnt++;
        }
        System.out.println(cnt);
    }
    
    static void union(int x, int y) {
        if (x < y) people[findSet(y)] = findSet(x);
        else people[findSet(x)] = findSet(y);
    }
    
    static int findSet(int z) {
        if (people[z] == z) return z;
        return people[z] = findSet(people[z]);
    }
}