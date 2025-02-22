import java.util.*;
import java.io.*;

public class b2293 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] arr, dp;
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[K+1];
    }

    static void dp() {
        dp[0] = 1;

        for (int i : arr) {
            for (int j=i; j<=K; j++) {
                dp[j] += dp[j - i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[K]));
        bw.flush();
        bw.close(); br.close();
    }
}