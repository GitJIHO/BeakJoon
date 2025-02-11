import java.util.*;
import java.io.*;

public class b2352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr, dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        Arrays.fill(dp, 1);

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static void dp() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    static void result() throws IOException {
        int max = 0;
        for (int i=0; i<N; i++) {
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
