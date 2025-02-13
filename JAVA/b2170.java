import java.util.*;
import java.io.*;

public class b2170 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int length;
    static ArrayList<int[]> list;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            list.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }
    }

    static void cal() {
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        length = 0;
        int[] init = list.get(0);
        int start = init[0];
        int end = init[1];

        for (int i=1; i<N; i++) {
            int[] val = list.get(i);
            if (val[0] <= end) {
                end = Math.max(end, val[1]);
                continue;
            } else {
                length += (end - start);
                start = val[0];
                end = val[1];
            }
        }
        length += (end - start);
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(length));
        bw.flush();
        bw.close(); br.close();
    }
}