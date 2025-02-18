import java.util.*;
import java.io.*;

public class b2343 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;
    static int total, left, right;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];

        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            right += arr[i];
            left = Math.max(left, arr[i]);
        }
    }

    static void find() throws IOException {
        while(left < right) {
            int mid = (left + right) / 2;
            int sum_size = 0;
            int need_count = 1;

            for (int i=0; i<N; i++) {
                if (sum_size + arr[i] <= mid) {
                    sum_size += arr[i];
                } else {
                    sum_size = arr[i];
                    need_count++;
                }
            }

            if (need_count > M) {
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