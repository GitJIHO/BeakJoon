import java.util.*;
import java.io.*;

public class b3067 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp, coin;
    static int N, goal;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coin = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(input[i]);
        }
        goal = Integer.parseInt(br.readLine());
        dp = new int[goal+1];
        dp[0] = 1;
    }

    static void cal() throws IOException {
        for (int i=0; i<N; i++) {
            for (int j=coin[i]; j<=goal; j++) {                    
                dp[j] += dp[j - coin[i]];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            input();
            cal();
            bw.write(String.valueOf(dp[goal]) + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}