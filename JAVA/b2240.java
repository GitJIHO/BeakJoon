import java.io.*;
import java.util.*;

public class b2240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, W;
    static int[][] dp;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        T = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);

        dp = new int[T+1][W+1];
    }

    static void dp() throws IOException {
        for (int i=1; i<=T; i++) {
            int tree = Integer.parseInt(br.readLine());
            
            for (int j=0; j<=W; j++) {
                if (j == 0) {
                    if (tree == 1) {
                        dp[i][j] = dp[i-1][j] + 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                    continue;
                }

                if (j % 2 == 0) {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    }
                }

                if (j % 2 == 1) {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    }
                }
            }
        }
    }

    static void result() throws IOException {
        int max = 0;
        for (int i=0; i<=W; i++) {
            max = Math.max(max, dp[T][i]);
        }

        bw.write(String.valueOf(max));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
