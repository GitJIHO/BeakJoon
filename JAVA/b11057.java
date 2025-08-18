import java.util.*;
import java.io.*;

public class b11057 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, result;
    static int MOD = 10007;
    static int[][] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];
        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }  
    }

    static void cal() {
        for (int i=2; i<=N; i++) {
            dp[i][0] = 1;
            for (int j=1; j<10; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
            }
        }

        for (int i=0; i<10; i++) {
            result += dp[N][i] % MOD;
        }
    }

    static void print() throws IOException {
        bw.write(String.valueOf(result % MOD));
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        print();
        bw.flush();
        bw.close(); br.close();
    }
}
