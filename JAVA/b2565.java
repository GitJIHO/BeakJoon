import java.util.*;
import java.io.*;

public class b2565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static ArrayList<int[]> list;
    static int[] arr, dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<int[]>();
        arr = new int[N];
        dp = new int[N];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);

            list.add(new int[] {n1, n2});
        }
    }

    static void cal() throws IOException {
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        for (int i=0; i<N; i++) {
            int[] l = list.get(i);
            arr[i] = l[1];
        }

        Arrays.fill(dp, 1);

        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    static void result() throws IOException {
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        bw.write(String.valueOf(N - max));
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}