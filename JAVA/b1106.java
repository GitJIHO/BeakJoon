import java.util.*;
import java.io.*;

public class b1106 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int C, N;
    static int[][] mat;
    static int[] dp;
    static int MAX_VALUE = 20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        dp = new int[C+101];

        mat = new int[N][2];
        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            int cost = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);

            mat[i][0] = cost;
            mat[i][1] = value;
        }
    }

    static void cal() {
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<N; i++) {
            int cost = mat[i][0];
            int value = mat[i][1];
            
            for (int j=value; j<C+101; j++) {
                if (dp[j-value] != MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-value] + cost);
                }
            }
        }
    }

    static void result() throws IOException {
        int min = MAX_VALUE;
        for (int i=C; i<C+101; i++) {
            min = Math.min(min, dp[i]);
        }
        bw.write(String.valueOf(min));
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}