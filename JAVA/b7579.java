import java.util.*;
import java.io.*;

public class b7579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] mat;
    static int[] dp;
    static int MAX_VALUE = 20000000;
    static int total_memory;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        mat = new int[N][2];

        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            mat[i][0] = Integer.parseInt(input[i]);
            total_memory += mat[i][0];
        }
        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            mat[i][1] = Integer.parseInt(input[i]);
        }
    }

    static void dp() {
        dp = new int[total_memory + 1];
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<N; i++) {
            int memory = mat[i][0];
            int cost = mat[i][1];

            for (int j=total_memory; j>=memory; j--) {
                dp[j] = Math.min(dp[j], dp[j-memory] + cost);
            }
        }
    }

    static void result() throws IOException {
        int result = MAX_VALUE;
        for (int i = M; i <= total_memory; i++) {
            result = Math.min(result, dp[i]);
        }
        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}