import java.util.*;
import java.io.*;

public class b12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] dp;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new int[K+1];

        for (int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            for (int j=K; j>=weight; j--) {
                dp[j] = Math.max(dp[j-weight]+value, dp[j]);
            }
        }
    }

    static void result() throws IOException {
        bw.write(String.valueOf(dp[K]));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}