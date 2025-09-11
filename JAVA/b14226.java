import java.util.*;
import java.io.*;

public class b14226 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static boolean[][] visited;
    static int MAX = 2000;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[MAX+1][MAX+1];
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0, 0});
        visited[1][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int clip = cur[1];
            int time = cur[2];

            if (num == N) return time;

            if (!visited[num][num]) {
                visited[num][num] = true;
                q.offer(new int[]{num, num, time+1});
            }

            if (clip > 0 && num + clip <= MAX && !visited[num+clip][clip]) {
                visited[num+clip][clip] = true;
                q.offer(new int[]{num+clip, clip, time+1});
            }

            if (num > 1 && !visited[num-1][clip]) {
                visited[num-1][clip] = true;
                q.offer(new int[]{num-1, clip, time+1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        input();
        int result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close(); br.close();
    }
}