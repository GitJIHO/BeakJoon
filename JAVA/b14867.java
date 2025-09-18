import java.io.*;
import java.util.*;

public class b14867 {
    static class State {
        int a;
        int b;
        int cnt;

        public State(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int A, B, C, D;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);
        D = Integer.parseInt(input[3]);
    }

    static void cal() throws IOException {
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(new State(0, 0, 0));
        visited.add("0,0");

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.a == C && cur.b == D) {
                bw.write(cur.cnt + "\n");
                return;
            }

            List<State> nextStates = new ArrayList<>();

            nextStates.add(new State(A, cur.b, cur.cnt + 1));
            nextStates.add(new State(cur.a, B, cur.cnt + 1));
            nextStates.add(new State(0, cur.b, cur.cnt + 1));
            nextStates.add(new State(cur.a, 0, cur.cnt + 1));

            int pour1 = Math.min(cur.a, B - cur.b);
            nextStates.add(new State(cur.a - pour1, cur.b + pour1, cur.cnt + 1));

            int pour2 = Math.min(cur.b, A - cur.a);
            nextStates.add(new State(cur.a + pour2, cur.b - pour2, cur.cnt + 1));

            for (State ns : nextStates) {
                String key = ns.a + "," + ns.b;
                if (!visited.contains(key)) {
                    visited.add(key);
                    q.offer(ns);
                }
            }
        }

        bw.write("-1\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close();
        br.close();
    }
}
