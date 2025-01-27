import java.util.*;
import java.io.*;

public class b10773 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Stack<Integer> stack;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0 && !stack.isEmpty()) {
                stack.pop();            
                continue;
            }
            stack.push(input);
        }
    }

    static void result() throws IOException {
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
