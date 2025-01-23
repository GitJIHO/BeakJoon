import java.util.*;
import java.io.*;

class Node {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class b1167 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> tree;

    static void input() throws IOException {
        V = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        visited = new boolean[V+1];
        tree = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i=0; i<V; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            for (int j=1; j<input.length; j+=2) {
                if (input[j].equals("-1")) {
                    break;
                } else {
                    int end = Integer.parseInt(input[j]);
                    int weight = Integer.parseInt(input[j+1]);

                    tree.get(start).add(new Node(end, weight));
                    tree.get(end).add(new Node(start, weight));
                }
            }
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
        return;
    }

    static int far() {
        int max = 0;
        int maxValue = 0;
        for (int i=1; i<=V; i++) {
            if (dist[i] > maxValue) {
                maxValue = dist[i];
                max = i;
            }
        }
        return max;
    }

    static void result() throws IOException {
        dfs(1);
        int start = far();
        
        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);

        dfs(start);
        int end = far();

        bw.write(String.valueOf(dist[end]));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
