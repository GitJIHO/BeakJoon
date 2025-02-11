import java.util.*;
import java.io.*;

public class b12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static ArrayList<Integer> LIS;
    static int N;
    static int length;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        LIS = new ArrayList<Integer>();

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static void cal() {
        LIS.add(arr[0]);
        for (int i=1; i<N; i++) {
            int pos = binarySearch(LIS, arr[i]);

            if (pos < 0) pos = -(pos + 1);

            if (pos >= LIS.size()) {
                LIS.add(arr[i]);
            } else {
                LIS.set(pos, arr[i]);
            }
        }
    }

    static int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -(left + 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(LIS.size()));
        bw.flush();
        bw.close(); br.close();
    }
}