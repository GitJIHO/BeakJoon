import java.util.*;
import java.io.*;

public class b14940 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static Queue<int[]> queue;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];
        queue = new LinkedList<>();

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for (int index=0; index<4; index++) {
                int nrow = row + drow[index];
                int ncol = col + dcol[index];

                if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < M && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    dist[nrow][ncol] = 1 + dist[row][col];
                    queue.add(new int[]{nrow, ncol});
                }
            }
        }
    }

    static void result() throws IOException {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dist[i][j] = -1;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
