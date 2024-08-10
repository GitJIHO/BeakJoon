import java.util.*;
import java.io.*;

public class b1764 {

    static int N;
    static int M;
    static int res = 0;
    static Map<String, String> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), "good");
        }
        for (int i = 0; i < M; i++) {
            String read = br.readLine();
            if(map.containsKey(read)) {
                res++;
                list.add(read);
            }
        }
    }

    static void res() throws IOException {
        Collections.sort(list);
        bw.write(res + "\n");
        for(String k : list) {
            bw.write(k + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        res();
        bw.flush();
        br.close();
        bw.close();
    }
}
