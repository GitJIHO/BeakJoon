import java.util.*;
import java.io.*;

public class b12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static Queue<Integer> queue;
    static int min_count;
    static int MAX = 100000;
    static int[] time;
    static int[] move = new int []{1, -1, 2};


    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        time = new int[MAX+1];
        queue = new LinkedList<Integer>();
        queue.add(N);
    }

    static void bfs() {
        if (N == K) {
			min_count++;
			return;
		}

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int i=0; i<3; i++) {
				int next;
				if (i==2) next = now * move[i];
				else next = now + move[i];
				
				if (next<0 || next>MAX || (time[next] != 0 && time[next] < time[now]+1)) continue;
				time[next] = time[now]+1;
				queue.add(next);
				
                if (next == K) min_count++;
            }
        }
    }
    
    static void result() throws IOException {
        bw.write(time[K] + "\n" + min_count);
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}