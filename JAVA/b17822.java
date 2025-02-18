import java.util.*;
import java.io.*;

public class b17822 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] mat;
    static int[] temp;
    static int sum, left;
    static int N, M, T;
    static boolean[] temp_same;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        mat = new int[N][M];
        temp = new int[M];
        sum = 0;
        left = N * M;

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                mat[i][j] = Integer.parseInt(input[j]);
                sum += mat[i][j];
            }
        }

        while (T-- > 0) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            turn(x, d, k);
            cal();
        }
    }

    static void turn(int x, int d, int k) {
        for (int i=x; i<=N; i+=x) {
            int row = i-1;
            int col;
            if (d == 0) {
                for (int j=0; j<M; j++) {
                    col = j - k;
                    if (col < 0) {
                        col += M;
                    }
                    temp[j] = mat[row][col];
                }
            } else {
                for (int j=0; j<M; j++) {
                    col = j + k;
                    if (col >= M) {
                        col -= M;
                    }
                    temp[j] = mat[row][col];
                }
            }

            for (int j=0; j<M; j++) {
                mat[row][j] = temp[j];
            }
        }
    }

    static void cal() throws IOException {
        boolean need = true;
        boolean[][] same = new boolean[N][M];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int col = j+1;
                if (col == M) col = 0;
                if (mat[i][j] == 0 || mat[i][col] == 0) continue;
                if (mat[i][j] == mat[i][col]) {
                    same[i][j] = true;
                    same[i][col] = true;
                    need = false;
                }
            }
        }
        for (int j=0; j<M; j++) {
            for (int i=0; i<N-1; i++) {
                if (mat[i][j] == 0 || mat[i+1][j] == 0) continue;
                if (mat[i][j] == mat[i+1][j]) {
                    same[i][j] = true;
                    same[i+1][j] = true;
                    need = false;
                }
            }
        }
        
        if (!need) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (same[i][j]) {
                        sum -= mat[i][j];
                        mat[i][j] = 0;
                        left--;
                    }
                }
            }
        } else {
            if (left == 0) return;
            double average = (double) sum / left;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (mat[i][j] == 0) continue;
                    if (!same[i][j]) {
                        if (mat[i][j] > average) {
                            mat[i][j]--;
                            sum--;
                        } else if (mat[i][j] < average) {
                            mat[i][j]++;
                            sum++;
                        }             
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close(); br.close();
    }
}
