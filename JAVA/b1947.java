import java.util.*;
import java.io.*;

public class b1947 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long[] nums;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        
        nums = new long[N+1];
    }

    static void cal() {
        nums[1] = 0;
        if (N >= 2) nums[2] = 1;
        for (int i=3; i<=N; i++) {
            nums[i] = (i-1) * (nums[i-2] + nums[i-1]) % 1000000000;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(nums[N] % 1000000000));
        bw.flush();
        bw.close(); br.close();        
    }
}

/*
1 0
2 1
3 2
4 9
5 44
*/
