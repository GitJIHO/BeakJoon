import java.io.*;
import java.util.*;

public class b6118 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist;
    static int MAX_INTEGER = 20000000;
    static int max_dist;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N+1];

        for (int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Arrays.fill(dist, MAX_INTEGER);
        dist[1] = 0;
        max_dist = 0;

        while(!queue.isEmpty()) {
            int start = queue.poll();

            for (int node : graph.get(start)) {
                if (dist[node] > dist[start] + 1) {
                    dist[node] = dist[start] + 1;
                    max_dist = Math.max(max_dist, dist[start] + 1);
                    queue.add(node);
                }
            }
        }
    }

    static void result() throws IOException {
        int count = 0;
        int num_first = 0;

        for (int i=1; i<=N; i++) {
            if (dist[i] == max_dist) {
                count++;
                if (num_first == 0) {
                    num_first = i;
                }
            }
        }

        bw.write(num_first + " " + max_dist + " " + count);
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
