import java.util.*;
import java.io.*;

public class b15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list;
    static int N, R, Q;
    static int[] count;
    static boolean[] visited;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        count = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            list.get(u).add(v);
            list.get(v).add(u);
        }
    }

    static int dfs(int cur) {
        visited[cur] = true;
        count[cur] = 1;

        for (int next : list.get(cur)) {
            if (!visited[next]) {
                count[cur] += dfs(next);
            }
        }

        return count[cur];
    }

    static void print() throws IOException {
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(count[num] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(R);
        print();
        bw.flush();
        bw.close(); br.close();
    }
}
