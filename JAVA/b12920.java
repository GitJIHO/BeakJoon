import java.util.*;
import java.io.*;

public class b12920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, C;
    static int[] dp;
    static ArrayList<int[]> list;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        dp = new int[M+1];
        list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            int count = Integer.parseInt(input[2]);

            for (int j=1; count>0; j*=2) {
                int num = Math.min(j, count);
                list.add(new int[] {weight * num, value * num});
                count -= num;
            }
        }
    }

    static void dp() {
        for (int[] i : list) {
            int weight = i[0];
            int value = i[1];

            for (int j=M; j>=weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(dp[M]));
        bw.flush();
        bw.close(); br.close();
    }
}