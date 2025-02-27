import java.util.*;
import java.io.*;

public class b15817 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, X;
    static int[][] mat;
    static int[] dp;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        dp = new int[X+1];
        mat = new int[N][2];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            mat[i][0] = Integer.parseInt(input[0]);
            mat[i][1] = Integer.parseInt(input[1]);
        }
    }

    static void dp() {
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            int length = mat[i][0];
            int count = mat[i][1];

            for (int j = X; j >= 0; j--) {
                for (int k = 1; k <= count; k++) {
                    int target = j - (length * k);
                    if (target >= 0) {
                        dp[j] += dp[target];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[X]));
        bw.flush();
        bw.close();
        br.close();
    }
}
