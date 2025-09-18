import java.util.*;
import java.io.*;

public class b11812 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long N, K, Q;
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Long.parseLong(input[0]);
        K = Long.parseLong(input[1]);
        Q = Long.parseLong(input[2]);

        for (int i = 0; i < Q; i++) {
            input = br.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);

            if (K == 1) {
                bw.write(Math.abs(a - b) + "\n");
            } else {
                bw.write(getDistance(a, b) + "\n");
            }
        }
    }

    static long getDistance(long a, long b) {
        long dist = 0;
        while (a != b) {
            if (a > b) {
                a = getParent(a);
            } else {
                b = getParent(b);
            }
            dist++;
        }
        return dist;
    }

    static long getParent(long i) {
        if (i == 1) return 1;
        return (i - 2) / K + 1;
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}
