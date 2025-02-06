import java.util.*;
import java.io.*;

public class b12852 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp, path;
    static int N;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        path = new int[N + 1];
    }

    static void dp() {
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }
    }

    static void result() throws IOException {
        bw.write(dp[N] + "\n");

        int index = N;
        while (index > 0) {
            bw.write(index + " ");
            index = path[index];
        }
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}