import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt();
            String[] key = sc.next().split("");
            int K = key.length;
            String[] sentence = sc.next().split("");
            int S = sentence.length;
            int cnt = 0;
            int i = 0;
            while (i < S) {
                if (sentence[i].equals(key[0]) && i <= S - K) {
                    int check = 0;
                    for (int j = 1; j < K; j++) {
                        if (!(key[j].equals(sentence[i + j]))) {
                            check = 1;
                            break;
                        }
                    }
                    if (check == 0) {
                        i += K;
                        cnt++;
                    }
                }
                i++;
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}