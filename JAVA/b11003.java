import java.io.*;
import java.util.*;

class Num {
    int index;
    int val;

    public Num(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

public class b11003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, L;
    static ArrayDeque<Num> deque;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        deque = new ArrayDeque<Num>();
    }

    static void cal() throws IOException {
        String[] input = br.readLine().split(" ");
        
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(input[i]);
            if (!deque.isEmpty() && deque.peek().index <= i - L) {
                deque.poll();
            }
            while (!deque.isEmpty() && deque.peekLast().val > num) {
                deque.pollLast();
            }
            deque.add(new Num(i, num));
            bw.write(deque.peek().val + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}