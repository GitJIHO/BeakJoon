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
        return weight - o.weight;
    }
}

public class b1916 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static ArrayList<ArrayList<Node>> list;
    static int[] dis;
    static boolean[] visited;
    static int startp;
    static int endp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        dis = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list.get(start).add(new Node(end, weight));
        }

        String[] input = br.readLine().split(" ");
        startp = Integer.parseInt(input[0]);
        endp = Integer.parseInt(input[1]);
    }

    static int dijkstra(int startp, int endp) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startp, 0));
        dis[startp] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.end;

            if (!visited[current]) {
                visited[current] = true;

                for (Node node : list.get(current)) {
                    if (!visited[node.end] && dis[node.end] > dis[current] + node.weight) {
                        dis[node.end] = dis[current] + node.weight;
                        pq.add(new Node(node.end, dis[node.end]));
                    }
                }
            }
        }

        return dis[endp];
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(dijkstra(startp, endp)));
        bw.flush();
        bw.close(); br.close();
    }
}
