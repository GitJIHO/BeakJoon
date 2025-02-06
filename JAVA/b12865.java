import java.util.*;
import java.io.*;

public class b12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[][] dp;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new int[N+1][K+1];

        for (int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            for (int j=1; j<=K; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i-1][j-weight]+value, dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    static void result() throws IOException {
        bw.write(String.valueOf(dp[N][K]));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}