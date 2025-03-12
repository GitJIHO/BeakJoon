import java.util.*;
import java.io.*;

public class b9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dp = new long[101];

    static void dp() throws IOException {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i=5; i<=100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        dp();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}
