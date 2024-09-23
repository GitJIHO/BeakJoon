import java.io.*;
import java.util.*;

public class b1932 {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int dp[][];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        N = sc.nextInt();
        dp = new int[N][];
        for(int i=0; i<N; i++) {
            dp[i] = new int[i+1];
            for(int j=0; j<=i; j++) {
                dp[i][j] = sc.nextInt();
            }
        }
    }

    static void cal() throws IOException {
        for(int i=N-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                dp[i-1][j] = Math.max(dp[i-1][j] + dp[i][j], dp[i-1][j] + dp[i][j+1]);
            }
        }
        bw.write(String.valueOf(dp[0][0]));
    }

    public static void main(String[] args) throws IOException{
        input();
        cal();
        bw.flush();
        bw.close();
    }
}
