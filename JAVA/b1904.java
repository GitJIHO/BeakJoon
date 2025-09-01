import java.util.*;
import java.io.*;

public class b1904 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dp;
    static int N;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
    }

    static void cal() {
        dp[1] = 1;
        if (N != 1) dp[2] = 2;

        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 15746; 
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(dp[N] % 15746));
        bw.flush();
        bw.close(); br.close();
    }
}