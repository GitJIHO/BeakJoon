import java.util.*;
import java.io.*;

public class b2589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] map, visited;
    static int R, C, max;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new boolean[R][C];

        for (int i=0; i<R; i++) {
            input = br.readLine().split("");
            for (int j=0; j<C; j++) {
                if (input[j].equals("L")) {
                    map[i][j] = true;
                }
            }
        }
        max = Integer.MIN_VALUE;
    }

    static void cal() {
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col, 0});
        visited = new boolean[R][C];
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            for (int i=0; i<4; i++) {
                int rx = rc[0] + dx[i];
                int ry = rc[1] + dy[i];

                if (rx >= 0 && rx < R && ry >= 0 && ry < C && !visited[rx][ry] && map[rx][ry]) {
                    visited[rx][ry] = true;
                    queue.add(new int[] {rx, ry, rc[2] + 1});
                    max = Math.max(max, rc[2] + 1);
                }
            }
        }        
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close(); br.close();
    }
}