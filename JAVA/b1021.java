import java.io.*;
import java.util.*;

public class b1021 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] targets;
    static Deque<Integer> deque = new LinkedList<>();
    static int count = 0;
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        targets = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }
        
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
    }
    
    static void cal() {
        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int idx = getIndex(target);
            int size = deque.size();
            
            if (deque.peekFirst() == target) {
                deque.pollFirst();
            } else if (idx <= size / 2) {
                while (deque.peekFirst() != target) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
                deque.pollFirst();
            } else {
                while (deque.peekFirst() != target) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
                deque.pollFirst();
            }
        }
    }
    
    static int getIndex(int target) {
        int idx = 0;
        for (int num : deque) {
            if (num == target) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
    
    static void result() throws IOException {
        bw.write(String.valueOf(count));
    }
    
    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
