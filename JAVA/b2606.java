import java.io.*;
import java.util.*;

public class b2606 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, V;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<V; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int node : graph.get(start)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
        return;
    }

    static void result() throws IOException {
        int result = 0;

        for (int i=2; i<=N; i++) {
            if (visited[i]) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(1);
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
