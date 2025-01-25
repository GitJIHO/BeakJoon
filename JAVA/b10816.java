import java.util.*;
import java.io.*;

public class b10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static Map<Integer, Integer> num = new HashMap<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(input[i]);

            if (num.containsKey(n)) {
                num.put(n, num.get(n) + 1);
            } else {
                num.put(n, 1);
            }
        }
    }

    static void result() throws IOException {
        M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            int m = Integer.parseInt(input[i]);

            if (num.containsKey(m)) {
                bw.write(String.valueOf(num.get(m)) + " ");
            } else {
                bw.write("0 ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
