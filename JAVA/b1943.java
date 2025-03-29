import java.util.*;
import java.io.*;

public class b1943 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] dp;

    static void input() throws IOException {
        int T = 3;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            ArrayList<Integer> coins = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int money = Integer.parseInt(input[0]);
                int count = Integer.parseInt(input[1]);

                int k = 1;
                while (count > 0) {
                    int use = Math.min(k, count);
                    coins.add(money * use);
                    sum += money * use;
                    count -= use;
                    k *= 2;
                }
            }

            if (sum % 2 != 0) {
                bw.write("0\n");
                continue;
            }

            int target = dp(sum, coins);

            bw.write(dp[target] ? "1\n" : "0\n");
        }
    }

    static int dp(int sum, ArrayList<Integer> coins) {
        int target = sum / 2;
        dp = new boolean[target + 1];
        dp[0] = true;

        for (int coin : coins) {
            for (int j = target; j >= coin; j--) {
                if (dp[j - coin]) dp[j] = true;
            }
        }

        return target;
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close();
        br.close();
    }
}
