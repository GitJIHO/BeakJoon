import java.util.*;
import java.io.*;

public class b16234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, L, R;
    static int[][] mat;
    static boolean[][] visited;
    static int[][] part;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static int part_num, result;
    static Map<Integer, int[]> map;
    static boolean move;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        mat = new int[N][N];
        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                mat[i][j] = Integer.parseInt(input[j]);
            }
        }
        result = 0;
    }   

    static void cal() {
        visited = new boolean[N][N];
        part = new int[N][N];
        part_num = 0;
        map = new HashMap<Integer, int[]>();
        move = false;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    part_num++;
                    map.put(part_num, new int[] {0, 0});
                    bfs(i, j);
                }
            }
        }

        int[] new_value = new int[part_num + 1];
        for (int i=1; i<=part_num; i++) {
            int[] cur = map.get(i);
            int temp = cur[0] / cur[1];
            new_value[i] = temp;          
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                mat[i][j] = new_value[part[i][j]];
            }
        }

        if (move) {
            result++;
            cal();
        }
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        int[] cur_part = map.get(part_num);
        
        int part_sum = cur_part[0];
        int part_count = cur_part[1];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;
            int cur_value = mat[cur[0]][cur[1]];
            part[cur[0]][cur[1]] = part_num;
            part_sum += cur_value;
            part_count++;

            for (int i=0; i<4; i++) {
                int rx = cur[0] + dx[i];
                int ry = cur[1] + dy[i];

                if (rx >= 0 && rx < N && ry >= 0 && ry < N) {
                    if (!visited[rx][ry]) {
                        int diff = Math.abs(mat[cur[0]][cur[1]] - mat[rx][ry]);
                        if (diff >= L && diff <= R) {
                            visited[rx][ry] = true;
                            part[rx][ry] = part_num;
                            move = true;
                            queue.add(new int[] {rx, ry});
                        }
                    }
                }
            }
        }

        map.put(part_num, new int[] {part_sum, part_count});
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close(); br.close();
    }
}