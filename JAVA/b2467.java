import java.util.*;
import java.io.*;

public class b2467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static int start, end;
    static int res1, res2;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static void cal() {
        start = 0;
        end = N - 1;
        int max = Integer.MAX_VALUE;

        while(start < end) {
            int val = arr[start] + arr[end];

            if (max > Math.abs(val)) {
                max = Math.abs(val);
                res1 = arr[start];
                res2 = arr[end];
            }

            if (val > 0) {
                end --;
            } else if (val < 0) {
                start ++;
            } else {
                res1 = arr[start];
                res2 = arr[end];
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(res1 + " " + res2);
        bw.flush();
        bw.close(); br.close();
    }
}