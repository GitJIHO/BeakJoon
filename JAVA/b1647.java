import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int start, end, weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class b1647 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int sumWeight;
    static ArrayList<Edge> graph;
    static int[] parent;
    static int count;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        sumWeight = 0;
        count = 0;
        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for (int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.add(new Edge(start, end, weight));
        }
    }

    static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    static void union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    static void kruskal() {
        Collections.sort(graph);
        int maxEdge = 0;

        for (Edge edge : graph) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                count++;
                sumWeight += edge.weight;
                maxEdge = Math.max(maxEdge, edge.weight);

                if (count == N-1) break;
            }
        }
        sumWeight -= maxEdge;
    }

    public static void main(String[] args) throws IOException {
        input();
        kruskal();
        bw.write(String.valueOf(sumWeight));
        bw.flush();
        bw.close(); br.close();
    }
}
