import java.util.*;
import java.io.*;

public class b1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int N, S, start, end, min, sum;
    static int MAX_VALUE = 20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N + 1];
        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static void cal() {
        start = 0;
        end = 0;
        min = MAX_VALUE;
        sum = 0;

        while (start <= end && end <= N) {
            if (sum < S) sum += arr[end++];
            else {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }
        }
    }

    public static void main(String[] args)  throws IOException {
        input();
        cal();
        bw.write(String.valueOf(min == MAX_VALUE ? 0 : min));
        bw.flush();
        bw.close(); br.close();
    }
}