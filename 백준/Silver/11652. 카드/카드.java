import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			Long num = Long.parseLong(br.readLine());
			if (map.get(num) == null) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		int max = 0;
		Long answer = 0L;
		for (Long key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
			if (map.get(key) == max) {
				answer = answer < key ? answer : key;
			}
		}
		
		System.out.println(answer);
	}
}