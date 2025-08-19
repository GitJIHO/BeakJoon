import java.util.*;
import java.io.*;

public class b6497 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;
    static int N, M, result, sum;
    static PriorityQueue<int[]> pq;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    static void cal() {
        result = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(u) != find(v)) {
                union(u, v);
                result += w;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            if (N == 0 && M == 0) break;

            parent = new int[N];
            for (int i = 0; i < N; i++) parent[i] = i;

            pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

            sum = 0;

            for (int i = 0; i < M; i++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                sum += w;
                pq.offer(new int[]{u, v, w});
            }

            cal();
            bw.write((sum - result) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
