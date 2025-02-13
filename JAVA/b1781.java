import java.util.*;
import java.io.*;

public class b1781 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<int[]> list;
    static int N;
    static PriorityQueue<Integer> pq;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int deadline = Integer.parseInt(input[0]);
            int cup = Integer.parseInt(input[1]);

            list.add(new int[] {deadline, cup});
        }
    }

    static void greedy() {
        Collections.sort(list, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    
        pq = new PriorityQueue<>();
        for (int[] l : list) {
            pq.add(l[1]);
            if (pq.size() > l[0]) {
                pq.poll();
            }
        }
    }

    static void result() throws IOException {
        int totalCups = 0;
        while (!pq.isEmpty()) {
            totalCups += pq.poll();
        }

        bw.write(String.valueOf(totalCups));
    }

    public static void main(String[] args) throws IOException {
        input();
        greedy();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}