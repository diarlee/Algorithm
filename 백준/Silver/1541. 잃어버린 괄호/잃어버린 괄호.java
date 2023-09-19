import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] nums = str.split("\\+|\\-");
		int numsSize = 0;
		for (int i = 0; i < nums.length; i++)
			numsSize += nums[i].length();
		String[] operators = new String[str.length() - numsSize];
		int oIdx = 0;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == '+' || str.charAt(i) == '-')
				operators[oIdx++] = Character.toString(str.charAt(i));
		String[] input = new String[nums.length + operators.length];
		for (int i = 0; i < nums.length; i++) {
			input[i * 2] = nums[i];
			if (i == nums.length - 1) break;
			input[i * 2 + 1] = operators[i];
		} // 여기까지 input 식을 숫자와 연산자로 구분한 배열로 만드는 과정
		int result = 0;
		int tmp = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i].equals("-")) {
				result -= tmp;
				tmp = 0;
			}
			else if (input[i].equals("+")) continue;
			else tmp += Integer.parseInt(input[i]);
		}
		if (tmp != 0) result += tmp;
		System.out.println(result);
	}
}