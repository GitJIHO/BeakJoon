import java.util.*;
import java.io.*;

public class b2225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static long[][] dp;
    static int VAL = 1000000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new long[K+1][N+1];
    }

    static void dp() {
        for (int i=0; i<=N; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=K; i++) {
            for (int j=0; j<=N; j++) {
                for (int k=0; k<=N; k++) {
                    if (dp[i-1][j] != 0 && j + k <= N) {
                        dp[i][j+k] += (dp[i-1][j] % VAL);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[K][N]%VAL));
        bw.flush();
        bw.close(); br.close();
    }
}