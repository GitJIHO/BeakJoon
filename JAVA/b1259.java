import java.util.*;
import java.io.*;

public class b1259 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<String> stack = new Stack<>(); 

    static void input() throws IOException {
        while(true) {
            String[] input = br.readLine().split("");
            if (input[0].equals("0") && input.length == 1) {
                return;
            }
            boolean check = true;
            int l = input.length;
            if (l == 1) {
                bw.write("yes\n");
                continue;
            } else if (l % 2 == 1) {
                for (int i = 0; i<l/2; i++) {
                    stack.add(input[i]);
                }
                for (int i = l/2+1; i<l; i++) {
                    if (!stack.pop().equals(input[i])) {
                        if (!stack.isEmpty()) {
                            stack.clear();
                        }
                        bw.write("no\n");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    bw.write("yes\n");
                }
                continue;
            } else {
                for (int i = 0; i<l/2; i++) {
                    stack.add(input[i]);
                }
                for (int i = l/2; i<l; i++) {
                    if (!stack.pop().equals(input[i])) {
                        if (!stack.isEmpty()) {
                            stack.clear();
                        }
                        bw.write("no\n");
                        check = false;
                        break;
                    }
                }
                if (check) {
                    bw.write("yes\n");
                }                
                continue;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();    
    }
}
