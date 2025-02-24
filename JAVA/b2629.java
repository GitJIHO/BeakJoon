import java.io.*;
import java.util.*;

public class b2629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, G;
    static int[] chu, gu;
    static boolean[][] dp;
    static int maxWeight = 0;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        chu = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            chu[i] = Integer.parseInt(input[i]);
            maxWeight += chu[i];
        }

        G = Integer.parseInt(br.readLine());
        gu = new int[G];
        input = br.readLine().split(" ");
        for (int i = 0; i < G; i++) {
            gu[i] = Integer.parseInt(input[i]);
        }

        dp = new boolean[N + 1][maxWeight + 1];
    }

    static void solve() {
        dp[0][0] = true;

        for (int i = 0; i < N; i++) {
            int c = chu[i];
            boolean[][] newDp = new boolean[N + 1][maxWeight + 1];

            for (int j = 0; j <= N; j++) {
                for (int w = 0; w <= maxWeight; w++) {
                    if (dp[j][w]) {
                        newDp[j][w] = true;
                        if (w + c <= maxWeight) {
                            newDp[j + 1][w + c] = true;
                        }
                        if (Math.abs(w - c) <= maxWeight) {
                            newDp[j + 1][Math.abs(w - c)] = true;
                        }
                    }
                }
            }
            dp = newDp;
        }
    }

    static void result() throws IOException {
        for (int weight : gu) {
            boolean canMeasure = false;
            for (int i = 0; i <= N; i++) {
                if (weight <= maxWeight && dp[i][weight]) {
                    canMeasure = true;
                    break;
                }
            }
            bw.write(canMeasure ? "Y " : "N ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        result();
        bw.flush();
        bw.close();
        br.close();
    }
}
