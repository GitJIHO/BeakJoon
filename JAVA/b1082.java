import java.util.*;
import java.io.*;

public class b1082 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int N, M;
    static String[] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        M = Integer.parseInt(br.readLine());
        dp = new String[M+1];
    }

    static void dp() {
        dp[0] = "";
        for (int cost = 0; cost <= M; cost++) {
            if (dp[cost] == null) continue;

            for (int num=0; num<N; num++) {
                int next = cost + arr[num];
                if (next > M) continue;

                if (dp[cost].equals("") && num == 0) continue;

                String candidate = dp[cost] + num;
                if (dp[next] == null || isBigger(candidate, dp[next])) {
                    dp[next] = candidate;
                }
            }
        }
    }

    static boolean isBigger(String a, String b) {
        if (a.length() != b.length()) return a.length() > b.length();
        return a.compareTo(b) > 0;
    }

    static void print() throws IOException {
        String ans = "0";
        for (int i=0; i<=M; i++) {
            if (dp[i] != null && isBigger(dp[i], ans)) {
                ans = dp[i];
            }
        }
        bw.write(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        print();
        bw.flush();
        bw.close(); br.close();
    }
}
