import java.io.*;
import java.util.*;

public class b2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbd = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        int[] arr = new int[N];
        int idx = 0;

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr[idx++] = num;
        }

        for(int i = 1; i < N; i++) {
            deque.offer(new int[]{arr[i], i+1 });
        }

        sbd.append(1).append(" ");

        int move = arr[0];

        for(int i = 1; i < N; i++) {

            if(move > 0) {
                for(int j = 1; j < move; j++) {
                    deque.offer(deque.poll());
                }

                int[] move_arr = deque.poll();
                move = move_arr[0];
                sbd.append(move_arr[1]).append(" ");
            }

            else {
                for(int j = 1; j <-move; j++) {
                    deque.offerFirst(deque.pollLast());
                }

                int[] move_arr = deque.pollLast();
                move = move_arr[0];
                sbd.append(move_arr[1]).append(" ");
            }
        }

        System.out.println(sbd);

    }
}