import java.io.*;

public class b11659 {

    static int N;
    static int M;
    static int[] sum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String st[] = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        
        sum = new int[N+1];
        st = br.readLine().split(" ");
        sum[0] = 0;
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st[i-1]);
        }
    }

    static void cal() throws IOException {
        String st[];
        for(int i=0; i<M; i++){
            st = br.readLine().split(" ");
            int from = Integer.parseInt(st[0]);
            int to = Integer.parseInt(st[1]);
            int result = sum[to] - sum[from-1];
            bw.write(result + "\n");            
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}
