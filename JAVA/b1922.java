import java.util.*;
import java.io.*;

public class b1922 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;
    static int N, M, result;
    static PriorityQueue<int[]> pq;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<> (
            (a, b) -> a[2] - b[2]
        );

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            pq.offer(new int[] {start, end, weight});
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    static void cal() {
        while (!pq.isEmpty()) {
            int[] num = pq.poll();
            int start = num[0];
            int end = num[1];
            int weight = num[2];

            if (find(start) != find(end)) {
                result += weight;
                union(start, end);
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