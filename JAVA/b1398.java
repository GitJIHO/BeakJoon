import java.io.*;
import java.util.*;

public class b1398 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> list;
    static int[] dp;

    static void precompute() {
        list = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            list.add((int) Math.pow(10, i));
        }

        for (int i = 0; i < 4; i++) {
            list.add(25 * (int) Math.pow(100, i));
        }

        dp = new int[10000];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : list) {
            for (int j = coin; j < 10000; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
    }

    static int solve(int M) {
        int totalCoins = 0;
        while (M > 0) {
            totalCoins += dp[M % 10000];
            M /= 10000;
        }
        return totalCoins;
    }

    public static void main(String[] args) throws IOException {
        precompute();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            sb.append(solve(M)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
