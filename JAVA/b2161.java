import java.io.*;
import java.util.*;

public class b2161 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer> result = new ArrayList<>();
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
    }
    
    static void cal() {
        while (queue.size() > 1) {
            result.add(queue.poll());
            queue.offer(queue.poll());
        }
        result.add(queue.poll());
    }
    
    static void output() throws IOException {
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + " ");
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        cal();
        output();
        bw.flush();
        bw.close(); br.close();
    }
}
