import java.util.*;
import java.io.*;

public class b1931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] mat;
    static int count;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        mat = new int[N][2];
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            mat[i][0] = Integer.parseInt(input[0]);
            mat[i][1] = Integer.parseInt(input[1]);
        }
    }

    static int cal() throws IOException {
        Arrays.sort(mat, Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));

        int end = 0;
        for (int[] i : mat) {
            if (i[0] >= end) {
                count++;
                end = i[1];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(cal()));
        bw.flush();
        bw.close(); br.close();
    }
}
