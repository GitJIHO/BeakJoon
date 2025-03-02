import java.util.*;
import java.io.*;

public class b1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> parents;
    static int T, N, K, target;
    static boolean[] visited;
    static int[] total_time;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
             String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            graph = new ArrayList<>();
            parents = new ArrayList<>();
            for (int i=0; i<=N; i++) {
                graph.add(new ArrayList<>());
                parents.add(new ArrayList<>());
            }
            
            total_time = new int[N+1];

            input = br.readLine().split(" ");
            for (int i=0; i<N; i++) {
                total_time[i+1] = Integer.parseInt(input[i]);
            }

            for (int i=0; i<K; i++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                graph.get(start).add(end);
                parents.get(end).add(start);
            }
            target = Integer.parseInt(br.readLine());

            visited = new boolean[N+1];
            cal();
            bw.write(String.valueOf(total_time[target]) + "\n");
        }
    }

    static void cal() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (parents.get(i).isEmpty()) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;

            for (int node : graph.get(cur)) {
                if (!visited[node]) {
                    boolean check = true;
                    int max = -1;
                    for (int parent : parents.get(node)) {
                        if (visited[parent]) {
                            max = Math.max(max, total_time[parent]);
                        } else {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        visited[node] = true;
                        total_time[node] += max;
                        queue.add(node);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}