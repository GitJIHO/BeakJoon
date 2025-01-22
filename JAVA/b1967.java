import java.util.*;
import java.io.*;

class Node {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class b1967 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Node>> tree;
    static int N;
    static int[] dist;
    static boolean[] visited;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }
        dist = new int[N+1];
        visited = new boolean[N+1];
        for (int i=0; i<N-1; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            tree.get(start).add(new Node(end, weight));
            tree.get(end).add(new Node(start, weight));
        }
    }

    static void dfs(int curNode) {
        visited[curNode] = true;

        for (Node node : tree.get(curNode)) {
            if (!visited[node.end]) {
                dist[node.end] = dist[curNode] + node.weight;
                dfs(node.end);
            }
        }
    }

    static int cal() throws IOException {
        dfs(1);
        int start = findFar();

        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);

        dfs(start);
        int end = findFar();
        return dist[end];        
    }

    static int findFar() throws IOException {
        int max = 0;
        int maxNode = 0;
        for (int i=1; i<=N; i++) {
            if (dist[i] > max) {
                max = dist[i];
                maxNode = i;
            }
        }
        return maxNode;
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(cal()));
        bw.flush();
        bw.close(); br.close();        
    }
}
