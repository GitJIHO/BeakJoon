import java.util.*;
import java.io.*;

public class b22115 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] arr;
    static int[] dp;
    static int MAX_VALUE = 20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        arr = new int[N];
        dp = new int[K+1];
        
        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static void dp() {
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<N; i++) {
            int caf = arr[i];
            for (int j=K; j>=caf; j--) {
                dp[j] = Math.min(dp[j - caf] + 1, dp[j]);
            }
        }
    }

    static void result() throws IOException {
        int result = dp[K];
        if (result == MAX_VALUE) {
            result = -1;
        }
        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}