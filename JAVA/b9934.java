import java.util.*;
import java.io.*;

public class b9934 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K, N;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] nums;

    static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, K) - 1;
        tree = new ArrayList<>();
        for (int i=0; i<K; i++) {
            tree.add(new ArrayList<>());
        }
        nums = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
    }

    static void cal(int start, int end, int height) {
        if (start > end) return;
        int root;
        if (start == end) {
            root = start;
        } else {
            root = (end + start) / 2;
        }
        tree.get(height).add(nums[root]);
        cal(start, root-1, height+1);
        cal(root+1, end, height+1);
    }

    static void result() throws IOException {
        for (int i=0; i<K; i++) {
            for (int j : tree.get(i)) {
                bw.write(String.valueOf(j) + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal(0, N-1, 0);
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
