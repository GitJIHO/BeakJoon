import java.io.*;
import java.util.*;

public class b24445 {
    static int N,M,R;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()); 

        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(List<Integer> l : graph){
            Collections.sort(l,Collections.reverseOrder());
        }

        BFS(R);


    }

    private static void BFS(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        int cnt = 0;
        int count[] = new int[N+1];
        while (!queue.isEmpty()){
            int now = queue.poll();
            count[now] = ++cnt;
            for(int i =0;i<graph.get(now).size();i++){


                int nextVertex = graph.get(now).get(i);
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
        for(int i=1;i<=N;i++) System.out.println(count[i]);


    }
}