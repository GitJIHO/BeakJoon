import java.util.*;
import java.io.*;

public class b2109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<int[]> lectures;
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        lectures = new ArrayList<>();

        for (int i = 0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int deadline = Integer.parseInt(input[1]);
            lectures.add(new int[]{price, deadline});
        }
    }

    static int solve() throws IOException {
        lectures.sort((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalMoney = 0;

        for (int[] lecture : lectures) {
            pq.add(lecture[0]);
            if (pq.size() > lecture[1]) {
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()) {
            totalMoney += pq.poll();
        }

        return totalMoney;
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(solve()));
        bw.flush();
        bw.close(); br.close();
    }
}
