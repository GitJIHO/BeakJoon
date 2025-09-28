import java.io.*;
import java.util.*;

public class b26597 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static String input() throws IOException {
        return br.readLine();
    }

    static void solve() throws IOException {
        int q = Integer.parseInt(input());
        processQuery(q);
    }

    static void processQuery(int q) throws IOException {
        long start = -1_000_000_000_000_000_000L;
        long end = 1_000_000_000_000_000_000L;
        int index = 0;

        for (int i = 1; i <= q; i++) {
            StringTokenizer st = new StringTokenizer(input());
            long x = Long.parseLong(st.nextToken());
            String op = st.nextToken();

            if (op.equals("^")) {
                start = Math.max(start, x + 1);
            } else if (op.equals("v")) {
                end = Math.min(end, x - 1);
            }

            if (start == end && index == 0) {
                index = i;
            } else if (start > end) {
                bw.write("Paradox!\n" + i + "\n");
                return;
            }
        }

        if (index == 0) {
            bw.write("Hmm...\n");
        } else {
            bw.write("I got it!\n" + index + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        bw.flush();
        bw.close(); br.close();
    }
}
