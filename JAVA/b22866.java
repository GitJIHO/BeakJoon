import java.util.*;
import java.io.*;

public class b22866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static int[] cnt;  
    static int[] near; 

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i+1] = Integer.parseInt(input[i]);
        }
        cnt = new int[N+1];
        near = new int[N+1];
    }

    static void cal() {
        Stack<Integer> stack = new Stack<>();
        for (int i=1; i<=N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                cnt[i] += stack.size();
                int candidate = stack.peek();
                if (near[i] == 0) {
                    near[i] = candidate;
                } else {
                    int curDist = Math.abs(i - near[i]);
                    int newDist = Math.abs(i - candidate);
                    if (newDist < curDist || (newDist == curDist && candidate < near[i])) {
                        near[i] = candidate;
                    }
                }
            }
            stack.push(i);
        }

        stack.clear();
        for (int i=N; i>=1; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                cnt[i] += stack.size();
                int candidate = stack.peek();
                if (near[i] == 0) {
                    near[i] = candidate;
                } else {
                    int curDist = Math.abs(i - near[i]);
                    int newDist = Math.abs(i - candidate);
                    if (newDist < curDist || (newDist == curDist && candidate < near[i])) {
                        near[i] = candidate;
                    }
                }
            }
            stack.push(i);
        }
    }

    static void print() throws IOException {
        for (int i=1; i<=N; i++) {
            if (cnt[i] == 0) {
                bw.write("0\n");
            } else {
                bw.write(cnt[i] + " " + near[i] + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        print();
        bw.flush();
        bw.close(); br.close();
    }
}
