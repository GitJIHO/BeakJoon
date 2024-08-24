import java.io.*;
import java.util.Arrays;

public class b15654 {

    static int N;
    static int M;
    static int[] arr;
    static int[] numbers;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException{
        String[] input = br.readLine().split(" ");
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        numbers = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        arr = new int[M];

        Arrays.sort(numbers);
    }

    static void dfs(int count) throws IOException{
        if(count == M) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++) {
            if(!visited[i-1]) {
                visited[i-1] = true;
                arr[count] = numbers[i-1];
                dfs(count + 1);
                visited[i-1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        dfs(0);
    }
}
