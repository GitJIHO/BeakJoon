import java.io.*;
import java.util.*;

public class b9465 {


    static int T;
    static int n;
    static int[][] mat;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            n = Integer.parseInt(br.readLine());
            mat = new int[2][n+1];
            dp = new int[2][n+1];
            for(int j=0; j<2; j++) {
                String[] input = br.readLine().split(" ");
                for(int k=1; k<=n; k++) {
                    mat[j][k] = Integer.parseInt(input[k-1]);
                }
            }
            check();
            clearArray();
        }
    }

    static void check() throws IOException {
        dp[0][1] = mat[0][1];
        dp[1][1] = mat[1][1];     
        for(int i=2; i<=n; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + mat[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + mat[1][i];
        }
        bw.write(String.valueOf(Math.max(dp[0][n], dp[1][n])+"\n"));
    }

    static void clearArray() {
        for(int[] row : mat) {
            Arrays.fill(row,0);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        bw.flush();
        bw.close(); br.close();
    }
}
