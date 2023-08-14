import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            SelectionSort(nums);
            System.out.println(nums[N / 2]);
        }
    }
    public static int[] SelectionSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int minIdx = i; // 선택
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[minIdx]) { // 선택값 이후 값들 중 최소값 구함
                    minIdx = j;
                }
            // 정렬
            int _tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = _tmp;
            }
        }
        return nums;
    }
}