import java.util.*;
import java.io.*;

public class b2461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] indexs;
    static int[][] mat;
    static int min;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        indexs = new int[N];
        mat = new int[N][M];

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                mat[i][j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(mat[i]);
        }
    }

    static void cal() {
        min = Integer.MAX_VALUE;

        boolean allReachedEnd = false;

        while(!allReachedEnd) {
            int num_min = mat[0][indexs[0]];
            int num_max = mat[0][indexs[0]];

            for (int i=1; i<N; i++) {
                num_min = Math.min(num_min, mat[i][indexs[i]]);
                num_max = Math.max(num_max, mat[i][indexs[i]]);
            }

            min = Math.min(min, num_max - num_min);

            int min_class = 0;
            for (int i=1; i<N; i++) {
                if (mat[i][indexs[i]] == num_min) {
                    min_class = i;
                    break;
                }
            }

            if (indexs[min_class] + 1 >= M) {
                allReachedEnd = true;
                break;
            }
            
            indexs[min_class]++;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close(); br.close();
    }
}