import java.util.*;
import java.io.*;

public class b14728 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, T;
    static int[][] mat;
    static int[] dp;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);
        
        mat = new int[N][2];
        dp = new int[T+1];

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            mat[i][0] = Integer.parseInt(input[0]);
            mat[i][1] = Integer.parseInt(input[1]);
        }
    }

    static void dp() {
        for (int i=1; i<=N; i++) {
            int time = mat[i-1][0];
            int value = mat[i-1][1];

            for (int j=T; j>=time; j--) {
                dp[j] = Math.max(dp[j], dp[j-time] + value);
            }
        }
    }

    static void result() throws IOException {
        bw.write(String.valueOf(dp[T]));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}