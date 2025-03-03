import java.io.*;
import java.util.*;

public class b1202 {
    static class J {
        int w,v;

        public J(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<J> jems;
    static PriorityQueue<Integer> bags;
    static PriorityQueue<J> pq;
    static int N, K;
    static long result;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        jems = new PriorityQueue<J>((a, b) -> a.w - b.w);

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            jems.add(new J(w, v));
        }

        bags = new PriorityQueue<Integer>((a, b) -> a - b);
        
        for (int i=0; i<K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        pq = new PriorityQueue<J>((a, b) -> b.v - a.v);
    }

    static void cal() {
        result = 0;
        while (!bags.isEmpty()) {
            int bag = bags.poll();

            while (!jems.isEmpty()) {               
                if (bag < jems.peek().w) break;
                pq.add(jems.poll());
            }

            if (!pq.isEmpty()) {
                result += pq.poll().v;
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