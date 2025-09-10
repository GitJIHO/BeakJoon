import java.util.*;
import java.io.*;

public class b11054 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] num, ascdp, descdp;
    static int N, result;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(input[i-1]);
        }
        ascdp = new int[N + 1];
        descdp = new int[N + 1];
    }

    static void dp() {
        Arrays.fill(ascdp, 1);
        Arrays.fill(descdp, 1);

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                if (num[i] > num[j]) {
                    ascdp[i] = Math.max(ascdp[i], ascdp[j] + 1);
                }
            }
        }

        for (int i=N; i>=1; i--) {
            for (int j=N; j>=i; j--) {
                if (num[i] > num[j]) {
                    descdp[i] = Math.max(descdp[i], descdp[j] + 1);
                }
            }
        }

        result = 0;
        for (int i=1; i<=N; i++) {
            result = Math.max(result, ascdp[i] + descdp[i] - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close(); br.close();
    }
}