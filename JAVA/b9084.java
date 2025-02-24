import java.util.*;
import java.io.*;

public class b9084 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N, M;
    static int money[];
    static int[] dp;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            
            money = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i=0; i<N; i++) {
                money[i] = Integer.parseInt(input[i]);
            }

            M = Integer.parseInt(br.readLine());

            dp = new int[M+1];
            dp();
            bw.write(String.valueOf(dp[M]) + "\n");
        }
    }

    static void dp() {
        dp[0] = 1;

        for (int i=0; i<N; i++) {
            int coin = money[i];
            for (int j=coin; j<=M; j++) {
                dp[j] += dp[j-coin];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}