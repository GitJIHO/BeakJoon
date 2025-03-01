import java.util.*;
import java.io.*;

public class b2568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<int[]> lines;
    static int[] parent;
    static int[] dp;
    static int N, result;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        
        lines = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            
            lines.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }
        
        parent = new int[N];
        dp = new int[N];

        Collections.sort(lines, (a, b) -> a[0] - b[0]);
        Arrays.fill(parent, -1);
    }

    static void dp() throws IOException {
        int[] arr = new int[N];
        int index = 0;
        for (int[] line : lines) {
            arr[index++] = line[1];
        }

        Arrays.fill(dp, 1);

        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }
    }

    static void result() throws IOException {
        int max = 0;
        int max_index = 0;
        for (int i=0; i<N; i++) {
            if (max < dp[i]) {
                max = dp[i];
                max_index = i;
            }
        }
        
        result = N - max;
        bw.write(String.valueOf(result) + "\n");

        Set<Integer> set = new HashSet<>();
        int next = max_index;
        while (next != -1) {
            set.add(lines.get(next)[1]);
            next = parent[next];
        }


        for (int[] line : lines) {
            if (!set.contains(line[1])) {
                bw.write(String.valueOf(line[0]) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}