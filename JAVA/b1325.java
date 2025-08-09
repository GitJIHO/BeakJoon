import java.util.*;
import java.io.*;

public class b1325 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<List<Integer>> list;
    static int n, m;
    static int[] count;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i=0; i<m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
        }
    }

    static void cal() {
        count = new int[n+1];

        for (int i=1; i<=n; i++) {
            bfs(i);
        }
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int num : list.get(x)) {
                if (!visited[num]) {
                    count[num]++;
                    visited[num] = true;
                    q.offer(num);
                }
            }
        }
    }

    static void print() throws IOException {
        int max = 0;
        for (int i=1; i<=n; i++) {
            max = Math.max(max, count[i]);
        }
        for (int i=1; i<=n; i++) {
            if (count[i] == max) {
                bw.write(i + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        print();
        bw.flush();
        bw.close(); br.close();
    }
}