import java.util.*;
import java.io.*;

public class b13913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] time;
    static int[] move = new int[] {-1, 1, 2};
    static int[] forward;
    static int MAX = 100000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        time = new int[MAX+1];
        forward = new int[MAX+1];
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(N);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int i=0; i<=2; i++) {
                int next;

                if (i == 2) next = now * move[i];
                else next = now + move[i];

                if (next < 0 || next > MAX || (time[next] != 0 && time[next] < time[now] + 1)) continue;
                time[next] = time[now] + 1;
                forward[next] = now;
                queue.add(next);
            }
        }
    }

    static void result() throws IOException {
        if (N == K) {
            bw.write("0\n" + K); 
            return;
        }

        Stack<Integer> result = new Stack<>();

        int now = K;
        while(now != N) {
            result.push(now);
            now = forward[now];
        }
        result.push(now);
        
        bw.write(String.valueOf(time[K]) + "\n");
        while(!result.isEmpty()) {
            bw.write(String.valueOf(result.pop() + " "));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}