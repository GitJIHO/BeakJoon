import java.util.*;
import java.io.*;

public class b1620 {

    static int N;
    static int M;
    static Map<String, String> pomap1 = new HashMap<>();
    static Map<String, String> pomap2 = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        for (int i = 1; i <= N; i++) {
            String read = br.readLine();
            pomap1.put(String.valueOf(i), read);
            pomap2.put(read, String.valueOf(i));
        }
    }

    static void find() throws IOException {
        String target;
        for (int i = 0; i < M; i++) {
            target = br.readLine();
            if (pomap1.containsKey(target)) {
                bw.write(pomap1.get(target) + "\n");
            } else {
                bw.write(pomap2.get(target) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
        bw.flush();
        br.close();
        bw.close();
    }
}
