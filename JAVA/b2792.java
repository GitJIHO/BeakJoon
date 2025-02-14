import java.util.*;
import java.io.*;

public class b2792 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] jewels;
    static int left, right, mid;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        jewels = new int[M];
        for (int i=0; i<M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, jewels[i]);
        }
    }

    static void find() {
        left = 1;

        while (left < right) {
            mid = (left + right) / 2;
            int sum = 0;

            for (int jewel : jewels) {
                if (jewel % mid == 0) {
                    sum += jewel / mid;
                } else {
                    sum += jewel / mid + 1;
                }
            }

            if (N < sum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
        bw.write(String.valueOf(left));
        bw.flush();
        bw.close(); br.close();
    }
}