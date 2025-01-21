import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class b17270 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V, M;
    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    static int J, S;
    static final int INF = 20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        input = br.readLine().split(" ");
        J = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
    }

    static int[] dijkstra(int V, int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node next : graph.get(cur)) {
                if (dist[next.end] > dist[cur] + next.weight) {
                    dist[next.end] = dist[cur] + next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist;
    }

    static int result(int V, int J, int S) {
        Set<Integer> start = new HashSet<>();
        start.add(J);
        start.add(S);
        
        int[] J_length = dijkstra(V, J);
        int[] S_length = dijkstra(V, S);
        
        int value = INF;
        List<Integer> ans = new ArrayList<>();
        
        for (int node = 1; node <= V; node++) {
            if (start.contains(node)) continue;
            if (J_length[node] == INF || S_length[node] == INF) continue;
            int nowValue = J_length[node] + S_length[node];
            if (nowValue < value) {
                ans.clear();
                value = nowValue;
            }

            if (nowValue == value && J_length[node] <= S_length[node]) {
                ans.add(node);
            }
        }

        if (!ans.isEmpty()) {
            ans.sort((a, b) -> {
                if (J_length[a] == J_length[b]) return Integer.compare(a, b);
                return Integer.compare(J_length[a], J_length[b]);
            });
            return ans.get(0);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(result(V, J, S)));
        bw.flush();
        bw.close();
        br.close();
    }
}
