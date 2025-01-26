import java.util.*;
import java.io.*;

public class b9935 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String target, s;
    static Stack<Character> result = new Stack<>();

    static void input() throws IOException {
        target = br.readLine();
        s = br.readLine();
    }
    
    static void cal() {
        int targetSize = target.length();
        int sSize = s.length();

        for (int i=0; i<targetSize; i++) {
            result.push(target.charAt(i));

            if (result.size() >= sSize) {
                boolean flag = true;

                for (int j=0; j<sSize; j++) {
                    if (result.get(result.size() - sSize + j) != s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j=0; j<sSize; j++) {
                        result.pop();
                    }
                }
            }
        }
    }

    static void result() throws IOException {
        if (result.size() == 0) {
            bw.write("FRULA");
            return;
        }
        for (Character c : result) {
            bw.write(c);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();

    }
}
