import java.util.*;
import java.io.*;

public class b2294 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] arr, dp;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        arr = new int[N];
        dp = new int[K+1];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void dp() {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<N; i++) {
            int coin = arr[i];
            for (int j=coin; j<=K; j++) {
                 if (dp[j-coin] != Integer.MAX_VALUE) {
                      dp[j] = Math.min(dp[j-coin] + 1, dp[j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        if (dp[K] == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else bw.write(String.valueOf(dp[K]));
        bw.flush();
        bw.close(); br.close();
    }
}