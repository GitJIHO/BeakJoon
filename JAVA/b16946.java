import java.io.*;
import java.util.*;

public class b16946 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] mat;
    static int[][] group;
    static int dx[] = new int[] {-1, 1, 0, 0};
    static int dy[] = new int[] {0, 0, -1, 1};
    static int groupid;
    static ArrayList<Integer> group_value;
    static boolean[][] visited;


    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        mat = new int[N][M];
        group = new int[N][M];
        group_value = new ArrayList<>();
        group_value.add(0);
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            input = br.readLine().split("");
            for (int j=0; j<M; j++) {
                mat[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    static void cal() {
        groupid = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (mat[i][j] == 0 && group[i][j] == 0) {
                    groupid++;
                    bfs(i, j);
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (mat[i][j] == 1) {
                    insert(i, j);
                }
            }
        }
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;
        group[row][col] = groupid;
        int value = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i=0; i<4; i++) {
                int curx = x + dx[i];
                int cury = y + dy[i];

                if (curx >= 0 && curx < N && cury >= 0 && cury < M) {
                    if (!visited[curx][cury] && mat[curx][cury] == 0) {
                        visited[curx][cury] = true;
                        group[curx][cury] = groupid;
                        queue.add(new int[] {curx, cury});
                        value++;
                    }
                }
            }
        }

        group_value.add(value);
    }

    static void insert(int row, int col) {
        int sum = 1;
        HashSet<Integer> counted_group = new HashSet<Integer>();

        for (int i=0; i<4; i++) {
            int curx = row + dx[i];
            int cury = col + dy[i];

            if (curx >= 0 && curx < N && cury >= 0 && cury < M) {
                int gid = group[curx][cury];
                if (gid > 0 && counted_group.add(gid)) {
                    sum += group_value.get(gid);
                }
            }
        }

        mat[row][col] = sum % 10;
    }

    static void result() throws IOException {
        for (int i[] : mat) {
            for (int j : i) {
                bw.write(j + "");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}