import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class b11723 {
	static int M, result, num;
	static String command;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (!(command.equals("all") || command.equals("empty"))) {
				num = Integer.parseInt(st.nextToken());
			}
			if (command.equals("add")) {
				result |= (1 << num);
			} else if (command.equals("remove")) {
				result &= ~(1 << num);
			} else if (command.equals("check")) {
				if ((result & (1 << num)) > 0) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (command.equals("toggle")) {
				result ^= (1 << num);
 
			} else if (command.equals("all")) {
				result = -1;
 
			} else if (command.equals("empty")) {
				result = 0;
			}
		}
		System.out.println(sb.toString());
	}
}