import java.util.*;
import java.io.*;

public class b2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] mat;
    static int N, num;
    static int[] count = new int[626];
    static boolean[][] visited;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        mat = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            String[] input = br.readLine().split("");
            for (int j=1; j<=N; j++) {
                mat[i][j] = Integer.parseInt(input[j-1]);        
            }
        }
    }

    static void cal() {
        visited = new boolean[N+1][N+1];
        
        num = 0;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (!visited[i][j] && mat[i][j] != 0) {
                    num++;
                    dfs(i, j, num);
                }        
            }
        }
    }

    static void dfs(int sx, int sy, int number) {
        visited[sx][sy] = true;
        mat[sx][sy] = number;
        count[number]++;

        for (int i=0; i<4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                if (!visited[nx][ny] && mat[nx][ny] != 0) {
                    dfs(nx, ny, number);
                }
            }            
        }
    }

    static void print() throws IOException {
        bw.write(num + "\n");
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> a - b
        );
        for(int i=1; i<=num; i++) {
            queue.offer(count[i]);
        }
        while (!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        print();
        bw.flush();
        bw.close(); br.close();
    }
}