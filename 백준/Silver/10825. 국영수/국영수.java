import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Student[] arr = new Student[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.kor == s2.kor && s1.eng == s2.eng && s1.math == s2.math) {
					return s1.name.compareTo(s2.name);
				}
				if (s1.kor == s2.kor && s1.eng == s2.eng)
					return s2.math - s1.math;
				if (s1.kor == s2.kor)
					return s1.eng - s2.eng;
				return s2.kor - s1.kor;
			}
		});;
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i].name);
		}
	}
}

class Student {
	String name;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}