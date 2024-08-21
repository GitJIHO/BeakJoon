import java.io.*;

public class b15652 {

    static int N;
    static int M;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];
    }

    static void dfs(int k, int count) throws IOException{
        if(count == M) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=k; i<=N; i++) {
            arr[count] = i;
            dfs(i, count + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        dfs(1, 0);
    }
}
