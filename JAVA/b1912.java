import java.util.*;
import java.io.*;

public class b1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, dp;
    static int N;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i+1] = Integer.parseInt(input[i]);
        }
    }

    static void dp() {
        dp[1] = arr[1];
        for (int i=2; i<=N; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }
    }

    static void result() throws IOException {
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(String.valueOf(max));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}