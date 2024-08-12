import java.io.*;

public class b2579 {

    static int N;
    static int[] arr = new int[301];
    static int[] max = new int[301];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void dp() throws IOException {
        max[1] = arr[1];
        max[2] = arr[1] + arr[2];
        max[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        for (int i=4; i<N+1; i++) {
            max[i] = Math.max(max[i-2] + arr[i], max[i-3] + arr[i-1] + arr[i]);
        }
        bw.write(String.valueOf(max[N]));
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        bw.flush();
        bw.close(); br.close();
    }
}
