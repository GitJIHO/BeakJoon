import java.util.*;
import java.io.*;

public class b14002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr;
        int[] dp;
        String[] input;
        int N;
        int maxNum = 0;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            maxNum = Math.max(maxNum, dp[i]);
        }
        int temp = N - 1;
        ArrayList<Integer> tempArr = new ArrayList<>();

        bw.write(maxNum + "\n");
        for (int i = temp, j = maxNum; i >= 0; i--) {
            if (dp[i] == j && j>0) {
                tempArr.add(arr[i]);
                temp = i;
                j--;
            }
        }

        for (int i = tempArr.size() - 1; i >= 0; i--) {
            bw.write(tempArr.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
