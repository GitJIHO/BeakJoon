import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class b1504 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int E;
    static int must1;
    static int must2;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        list = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Node>());
        }
        
        for (int i=0; i<E; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        input = br.readLine().split(" ");
        must1 = Integer.parseInt(input[0]);
        must2 = Integer.parseInt(input[1]);        
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
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

        return dist[end] == INF ? INF : dist[end];
    }

    static void result() throws IOException {
        long result1 = dijkstra(1, must1) 
        + dijkstra(must1, must2) + dijkstra(must2, N);
        
        long result2 = dijkstra(1, must2) 
        + dijkstra(must2, must1) + dijkstra(must1, N);

        long result = Math.min(result1, result2);

        if (result >= INF) {
            result = -1;
        }

        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();

        bw.flush();
        bw.close(); br.close();
    }
}
