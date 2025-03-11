import java.util.*;
import java.io.*;

public class b1766 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static int[] indegree;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        indegree = new int[N+1];

        for (int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int next = Integer.parseInt(input[1]);

            list.get(num).add(next);
            indegree[next]++;
        }
    }

    static void cal() throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        
        while (!pq.isEmpty()) {
            int now = pq.poll();
            bw.write(now + " ");

            for (int n : list.get(now)) {
                indegree[n]--;

                if (indegree[n] == 0) {
                    pq.offer(n);
                }
            }
        }        
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}