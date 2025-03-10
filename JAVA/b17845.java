import java.util.*;
import java.io.*;

public class b17845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static int N, K;
    static int[][] mat;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new int[N+1];
        mat = new int[K][2];

        for (int i=0; i<K; i++) {
            input = br.readLine().split(" ");
            int value = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);

            mat[i][0] = value;
            mat[i][1] = weight;
        }
    }

    static void dp() {
        for (int i=0; i<K; i++) {
            int value = mat[i][0];
            int weight = mat[i][1];

            for (int j=N; j>=weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close(); br.close();
    }
}