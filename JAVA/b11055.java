import java.util.*;
import java.io.*;

public class b11055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] dp;
    static int N;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            dp[i] = arr[i];
        }
    }

    static void dp() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
    }

    static void result() throws IOException {
        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(dp[i], max);
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