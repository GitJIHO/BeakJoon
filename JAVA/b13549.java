import java.util.*;
import java.io.*;

public class b13549 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
    }

    static int result(int start, int target) {
        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int count = current[1];

            if (position == target) {
                return count;
            }

            int[] nextP = {position * 2, position - 1, position + 1};
            for (int next : nextP) {
                if (next>= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    if (next == position * 2) {
                        queue.add(new int[] {next, count});
                    } else {
                        queue.add(new int[] {next, count+1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(result(N, K)));
        bw.flush();
        bw.close(); br.close();
    }
}
