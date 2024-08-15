import java.io.*;

public class b1463 {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
    }

    static void cal(int N, int num) { //dfs - 시간초과
        if(N<1) return;
        if(N == 1){
            if(num < min) min = num;
            return;
        }
        if (N>1) {
            cal(N-1, num + 1);
        }
        if(N%3 == 0){
            cal(N/3, num + 1);
        } 
        if(N%2 == 0){
           cal(N/2, num + 1); 
        }
    }

    static void dp() { //dp
        dp[1] = 0;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            if(i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        // cal(N, 0);
        dp();

        // bw.write(String.valueOf(min));
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
