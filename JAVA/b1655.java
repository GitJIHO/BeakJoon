import java.util.*;
import java.io.*;

public class b1655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Integer> left, right;
    static int N, number;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>((a, b) -> a - b);
        
        for (int i=0; i<N; i++) {
            number = Integer.parseInt(br.readLine());
        
            int answer = cal(number);
        
            bw.write(answer + "\n");
        }
    }

    static int cal(int num) throws IOException {
        left.offer(num);

        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.offer(left.poll());
        }

        if (left.size() - 1 > right.size()) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }

        return left.peek();
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}