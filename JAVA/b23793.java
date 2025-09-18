import java.util.*;
import java.io.*;

public class b23793 {
    static class Node implements Comparable<Node> {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, X, Y, Z;
    static ArrayList<ArrayList<Node>> graph;
    static final long INF = Long.MAX_VALUE / 4;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.get(start).add(new Node(end, weight));
        }

        input = br.readLine().split(" ");
        X = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);
        Z = Integer.parseInt(input[2]);
    }

    static long dijkstra(int start, int end, int ban) {
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight != dist[cur.end]) continue;

            if (cur.end == ban) continue;

            if (cur.end == end) return dist[end];

            for (Node next : graph.get(cur.end)) {
                if (next.end == ban) continue;

                long nd = dist[cur.end] + next.weight;
                if (nd < dist[next.end]) {
                    dist[next.end] = nd;
                    pq.offer(new Node(next.end, nd));
                }
            }
        }

        return dist[end];
    }

    static void print() throws IOException {
        long d1 = dijkstra(X, Y, -1);
        long d2 = dijkstra(Y, Z, -1);
        long res1 = (d1 >= INF || d2 >= INF) ? -1 : ( (d1 + d2 >= INF) ? -1 : d1 + d2 );

        long res2temp = dijkstra(X, Z, Y);
        long res2 = (res2temp >= INF) ? -1 : res2temp;

        bw.write(res1 + " " + res2);
    }

    public static void main(String[] args) throws IOException {
        input();
        print();
        bw.flush();
        bw.close();
        br.close();
    }
}
