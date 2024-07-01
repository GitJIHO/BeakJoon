import java.io.*;

public class b11048_2 {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] dp = new int[N][M];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                dp[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int left = 0, up = 0, leftup = 0;

                if (i == 0 && j == 0) continue;
                if (i != 0) up = dp[i - 1][j];
                if (j != 0) left = dp[i][j - 1];
                if (i != 0 && j != 0) leftup = dp[i - 1][j - 1];

                dp[i][j] = dp[i][j] + Math.max(left, Math.max(leftup, up));
            }
        }

        bw.write(dp[N - 1][M - 1] + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
