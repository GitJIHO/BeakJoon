import java.util.*;
import java.io.*;

public class b5557 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static long[][] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dp = new long[N][21];
    }
    
    static void dp() {
        dp[0][arr[0]] = 1;

        for (int i=1; i<N-1; i++) {
            for (int j=0; j<=20; j++) {
                if (dp[i-1][j]!=0) {
                    int plus = j + arr[i];
                    int minus = j - arr[i];
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[N-2][arr[N-1]]));
        bw.flush();
        bw.close(); br.close();
    }
}