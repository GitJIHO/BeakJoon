import java.util.*;
import java.io.*;

public class b18258 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    static void cal() throws IOException {
        N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            if (command.equals("push")) {
                int num = Integer.parseInt(input[1]);
                dq.offerLast(num);
            } else if (command.equals("pop")) {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.pollFirst() + "\n");
                }
            } else if (command.equals("size")) {
                bw.write(dq.size() + "\n");
            } else if (command.equals("empty")) {
                if (dq.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (command.equals("front")) {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.peekFirst() + "\n");
                }
            } else {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.peekLast() + "\n");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}