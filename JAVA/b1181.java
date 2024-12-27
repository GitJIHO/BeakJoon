import java.util.*;
import java.io.*;

public class b1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Set<String> s = new HashSet<>();
    static List<String> ar;
    static Map<String, Integer> result = new HashMap<>();
    static Map<Integer, String> count = new HashMap<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            s.add(br.readLine());
        }
    }

    static void arrange() {
        ar = new ArrayList<>(s);
        Collections.sort(ar);
    }

    static void result() throws IOException {
        int index = 0;
        for (String a : ar) {
            result.put(a, a.length());
            count.put(index, a);
            index++;
        }
        for (int j=1; j<=50; j++) {
            for(int i=0; i<result.size(); i++) {
                if (result.get(count.get(i)).equals(j)) {
                    bw.write(count.get(i) + "\n");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        arrange();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
