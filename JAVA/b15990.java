import java.util.*;
import java.io.*;

public class b15990 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N;
    static int MAX = 100000;
    static long[][] dp = new long[MAX+1][4];
    static int MOD = 1000000009;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            bw.write((dp[N][1] + dp[N][2] + dp[N][3]) % MOD + "\n");
        }
    }

    static void cal() {
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= MAX; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        cal();
        input();
        bw.flush();
        bw.close(); br.close();
    }
}