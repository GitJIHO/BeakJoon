import java.io.*;
import java.util.*;

public class b18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int[] res = array.clone();

        Arrays.sort(array);

        Map<Integer, Integer> nums = new HashMap<>();

        int n = 0;
        for (int i : array) {
            if (!nums.containsKey(i)) {
                nums.put(i, n++);
            }
        }

        for (int i : res) {
            bw.write(nums.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}