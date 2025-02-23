import java.io.*;
import java.util.*;

public class b1398 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, M;
    static ArrayList<Integer> list;
    static int[] dp;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            M = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            int k = 0;
            boolean over1 = false;
            boolean over2 = false;
            while(!over1 || !over2) {
                if (!over1 && Math.pow(10, k) <= M) {
                    list.add((int)Math.pow(10, k));
                } else {
                    over1 = true;
                }

                if (!over2 && 25 * Math.pow(100, k) <= M) {
                    list.add(25 * (int)Math.pow(100, k));
                } else {
                    over2 = true;
                }

                k++;
            }

            cal();
            bw.write(String.valueOf(dp[M]) + "\n");
        }
    }

    static void cal() throws IOException {
        dp = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<list.size(); i++) {
            int coin = list.get(i);
            for (int j=coin; j<=M; j++) {
                if (dp[j-coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j-coin] + 1, dp[j]);
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