import java.io.*;
import java.util.*;

public class b10814 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<String[]> list = new ArrayList<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new String[] {input[0], input[1]});
        }
    }

    static void result() throws IOException {
        list.sort(Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        for (String[] s : list) {
            bw.write(s[0] + " " + s[1] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
