import java.util.*;
import java.io.*;

public class b1535 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, hp;
    static int[] L, J;
    static int[][] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        L = new int[N+1];
        J = new int[N+1];
        String[] input = br.readLine().split(" ");
        for (int i=1; i<=N; i++) {
            L[i] = Integer.parseInt(input[i - 1]);
        }
        input = br.readLine().split(" ");
        for (int i=1; i<=N; i++) {
            J[i] = Integer.parseInt(input[i - 1]);
        }
        dp = new int[N+1][100];
        hp = 99;
    }

    static void dp() {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=hp; j++) {
                if (L[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-L[i]]+J[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[N][hp]));
        bw.flush();
        bw.close(); br.close();
    }
}
