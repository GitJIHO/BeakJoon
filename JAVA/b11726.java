import java.io.*;

public class b11726 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] result;
    static final int MOD = 10007;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        result = new int[N+1];
    }

    static void cal() throws IOException {
        result[0] = 1;
        result[1] = 2;
        
        for (int i=2; i<=N; i++) {
            result[i] = (result[i-1] + result[i-2]) % MOD;
        }

        bw.write(String.valueOf(result[N-1]));
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}
