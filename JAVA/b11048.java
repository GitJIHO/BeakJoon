import java.io.*;
import java.util.*;


public class b11048 {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int left = 0, up = 0, leftup = 0;

                if(i==0 && j==0) continue;
                if(i!=0) up = dp[i-1][j];
                if(j!=0) left = dp[i][j-1];
                if(i!=0 && j!=0) leftup = dp[i-1][j-1];

                dp[i][j] = dp[i][j] + Math.max(left, Math.max(leftup, up));
            }
        }

        bw.write(Integer.toString(dp[N-1][M-1]));
        bw.flush();
        bw.close(); br.close();
    }
}