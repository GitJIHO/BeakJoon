import java.io.*;

public class b2096 {

    static int N;
    static int[][] min;
    static int[][] max;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        min = new int[N+1][3];
        max = new int[N+1][3];
        
        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            min[i][0] = a + Math.min(min[i-1][0], min[i-1][1]);
            min[i][1] = b + Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
            min[i][2] = c + Math.min(min[i-1][1], min[i-1][2]);

            max[i][0] = a + Math.max(max[i-1][0], max[i-1][1]);
            max[i][1] = b + Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
            max[i][2] = c + Math.max(max[i-1][1], max[i-1][2]);
        }
    }

    static void result() throws IOException {
        bw.write(String.valueOf(Math.max(max[N][0], Math.max(max[N][1], max[N][2]))));
        bw.write(" ");
        bw.write(String.valueOf(Math.min(min[N][0], Math.min(min[N][1], min[N][2]))));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
