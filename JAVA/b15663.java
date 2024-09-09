import java.util.*;
import java.io.*;

public class b15663 {

    static int N;
    static int M;
    static int[] arr;
    static int[] res;
    static boolean[] use;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        String[] nums = br.readLine().split(" ");
        arr = new int[N];
        res = new int[M];
        use = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(arr);
    }

    static void cal(int count) throws IOException {
        if(count == M) {
            for(int i=0; i<M; i++) {
                bw.write(res[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        int lastUsed = -1;

        for(int i=0; i<N; i++) {
            if(!use[i] && arr[i] != lastUsed) {
                res[count] = arr[i];
                use[i] = true;
                cal(count + 1);
                use[i] = false;
                lastUsed = arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        cal(0);
        bw.flush();
        bw.close(); br.close();
    }
}
