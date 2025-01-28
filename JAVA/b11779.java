import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class b11779 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    static int startP, endP;
    static int INF = 20000000;
    static int[] prev;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        prev = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.get(start).add(new Node(end, weight));
        }
        String[] input = br.readLine().split(" ");
        startP = Integer.parseInt(input[0]);
        endP = Integer.parseInt(input[1]);
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        Arrays.fill(prev, -1);

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;
                
                for (Node node : graph.get(cur)) {
                    if (!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        prev[node.end] = cur;

                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    static void result() throws IOException {
        bw.write(String.valueOf(dist[endP]) + "\n");

        Stack<Integer> stack = new Stack<>();
        int cur = endP;
        while (cur != -1) {
            stack.push(cur);
            cur = prev[cur];
        }

        bw.write(String.valueOf(stack.size()) + "\n");
        while (!stack.isEmpty()) {
            bw.write(String.valueOf(stack.pop()) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(startP);
        result();
        bw.flush();
        bw.close(); br.close();        
    }
}
