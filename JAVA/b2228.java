import java.util.*;
import java.io.*;

public class b2228 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static int[] sum;
    static int N, M;
    static int MIN = -20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dp = new int[N+1][M+1];
        sum = new int[N+1];
        for (int i=0; i<N; i++) {
            sum[i+1] = Integer.parseInt(br.readLine()) + sum[i];
        }
    }

    static void dp() {
        for (int i=0; i<=N; i++) {
            Arrays.fill(dp[i], MIN);
        }
        dp[0][0] = 0;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = dp[i-1][j];
                
                for (int k=1; k<=i; k++) {
                    if (j == 1) {
                        dp[i][j] = Math.max(dp[i][j], sum[i] - sum[k-1]);
                    } else if (k >= 2) {
                        dp[i][j] = Math.max(dp[i][j], dp[k-2][j-1] + sum[i] - sum[k-1]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[N][M]));
        bw.flush();
        bw.close(); 
        br.close();
    }
}
