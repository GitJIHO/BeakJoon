import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int e, int w) {
        this.end = e;
        this.weight = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class b1753 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V, E, K;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list;
    static final int INF = 20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        K = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            list.add(new ArrayList<>());
        }

        dist = new int[V+1];
        visited = new boolean[V+1];

        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        for (int i=0; i<E; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list.get(start).add(new Node(end, weight));
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : list.get(cur)) {
                    if (!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    static void result() throws IOException {
        for (int i=1; i<=V; i++) {
            int result = dist[i];
            if (result == INF) {
                bw.write("INF\n");
            } else {
                bw.write(String.valueOf(result) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(K);
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
