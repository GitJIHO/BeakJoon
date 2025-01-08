import java.util.*;
import java.io.*;

public class b7568 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<int[]> list = new ArrayList<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            list.add(new int[]{weight, height, 1});
        }
    }

    static void cal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1]) {
                    list.get(i)[2]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        for (int[] person : list) {
            bw.write(person[2] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
