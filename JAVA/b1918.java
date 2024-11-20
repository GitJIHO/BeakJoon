import java.io.*;
import java.util.*;

public class b1918 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] input;
    static Stack<String> stack = new Stack<>();

    static void input() throws IOException {
        input = br.readLine().split("");
    }

    static int precedence(String operator) {
        if ("+".equals(operator) || "-".equals(operator)) {
            return 1;
        } else if ("*".equals(operator) || "/".equals(operator)) {
            return 2;
        }
        return 0;
    }

    static void convert() throws IOException {
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            
            if (!"+".equals(s) && !"-".equals(s) && !"*".equals(s) && !"/".equals(s) && !"(".equals(s) && !")".equals(s)) {
                bw.write(s);
            } 
            else if ("(".equals(s)) {
                stack.push(s);
            } 
            else if (")".equals(s)) {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    bw.write(stack.pop());
                }
                stack.pop();
            } 
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(s)) {
                    bw.write(stack.pop());
                }
                stack.push(s);
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        convert();
        bw.flush();
        bw.close();
        br.close();
    }
}
