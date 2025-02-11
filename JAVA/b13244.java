import java.io.*;
import java.util.*;

public class b13244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    static boolean[] visited, finished;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean cycle;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            cal();    
        }
    }

    static void cal() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        finished = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        cycle = false;

        int components = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, -1);
            }
        }

        if (cycle || components > 1) {
            bw.write("graph\n");
        } else {
            bw.write("tree\n");
        }
    }

    static void dfs(int node, int parent) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) dfs(next, node);
            else if(next != parent) {
                cycle = true;
            } 
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}