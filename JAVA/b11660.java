import java.io.*;

public class b11660 {

    static int N;
    static int M;
    static int[][] mat;
    static int[][] sum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        mat = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<N+1; j++) {
                mat[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        sum = new int[N+1][N+1];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] + mat[i][j] - sum[i-1][j-1];
            }
        }
    }

    static void cal() throws IOException {
        for(int j=0; j<M; j++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int result = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            bw.write(String.valueOf(result) + " \n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}
