import java.util.*;
import java.io.*;

public class b18427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static int N, M, H;
    static List<Integer>[] mat;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        
        mat = new ArrayList[N];

        for (int i=0; i<N; i++) {
            mat[i] = new ArrayList<>();
            input = br.readLine().split(" ");
            for (String s : input) {
                mat[i].add(Integer.parseInt(s));
            }
        }

        dp = new int[H + 1];    
    }

    static void dp() {
        dp[0] = 1;

        for (int i=0; i<N; i++) {
            int[] next_dp = dp.clone();
            for (int height : mat[i]) {
                for (int k=H; k>=height; k--) {
                    next_dp[k] = (next_dp[k] + dp[k - height]) % 10007;
                }
            }
            dp = next_dp;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[H]));
        bw.flush();
        bw.close(); br.close();
    }
}