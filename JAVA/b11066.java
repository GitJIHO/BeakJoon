import java.util.*;
import java.io.*;

public class b11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N;
    static int[][] dp;
    static int[] files;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            files = new int[N+1];
            files[0] = 0;
            String[] input = br.readLine().split(" ");
            for (int i=1; i<=N; i++) {
                files[i] = files[i-1] + Integer.parseInt(input[i-1]);
            }

            dp = new int[N+1][N+1];
            dp[0][0] = 0;

            dp();
            bw.write(String.valueOf(dp[1][N]) + "\n");
        }
    }
    static void dp() {
        for (int gap=1; gap<N; gap++) {
            for (int start = 1; start+gap<=N; start++) {
                int end = start+gap;
                dp[start][end] = Integer.MAX_VALUE;

                for (int mid = start; mid<end; mid++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid+1][end] + files[end] - files[start-1]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}