import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class b1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V, E;
    static int sumWeight;
    static ArrayList<Edge> edges;
    static int[] parent;
    static int count;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        edges = new ArrayList<Edge>();
        parent = new int[V+1];
        
        for (int i=1; i<=V; i++) {
            parent[i] = i;
        }

        for (int i=0; i<E; i++) {
            input = br.readLine().split(" ");
            int src = Integer.parseInt(input[0]);
            int dest = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            edges.add(new Edge(src, dest, weight));
        }
    }

    static int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }

    static void union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if (parent[root1] != parent[root2]) {
            parent[root2] = root1;
        }
    }

    static void kruscal() {
        Collections.sort(edges);
        count = 0;
        sumWeight = 0;

        for (Edge edge : edges) {
            if (find(edge.src) != find(edge.dest)) {
                union(edge.src, edge.dest);
                sumWeight += edge.weight;
                count++;
            }
            if (count == V-1) break;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        kruscal();
        bw.write(String.valueOf(sumWeight));
        bw.flush();
        bw.close(); br.close();
    }
}