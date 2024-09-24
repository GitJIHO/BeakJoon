import java.io.*;

public class b1149 {

    static int N;
    static int[][] dp;
    static int red;
    static int green;
    static int blue;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
    }

    static void dp() throws IOException {
        String[] input = br.readLine().split(" ");
        dp[0][0] = Integer.parseInt(input[0]);
        dp[0][1] = Integer.parseInt(input[1]);
        dp[0][2] = Integer.parseInt(input[2]);

        for(int i=1; i<N; i++) {
            input = br.readLine().split(" ");
            red = Integer.parseInt(input[0]);
            green = Integer.parseInt(input[1]);
            blue = Integer.parseInt(input[2]);

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;
        }
        bw.write(String.valueOf(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]))));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.flush();
        bw.close(); br.close();
    }
}
