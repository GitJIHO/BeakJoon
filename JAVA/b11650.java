import java.io.*;
import java.util.*;

public class b11650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] nums;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N][2];
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(input[0]);
            nums[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(nums, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt((int[] o) -> o[1]));
    }

    static void result() throws IOException {
        for (int[] i : nums) {
            bw.write(String.valueOf(i[0]) + " ");
            bw.write(String.valueOf(i[1]) + "\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
