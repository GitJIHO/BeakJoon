import java.io.*;

public class b20040 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] parent;
    static int result;
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }
    }

    static int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (parent[root1] != parent[root2]) {
            parent[root2] = root1;
        }
    }

    static void cal() throws IOException {
        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            if (find(start) != find(end)) {
                union(start, end);
            } else {
                result = i + 1;
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close(); br.close();
    }
}
