import java.util.*;
import java.io.*;

public class b11399 {

    static int N;
    static int[] arr;
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] st = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
    }

    static void result() {
        Arrays.sort(arr);
        for(int i=1; i<N; i++){
            arr[i] += arr[i-1];
            result += arr[i-1];
        }
        result += arr[N-1];
    }
        
    public static void main(String[] args) throws IOException{
        input();
        result();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close(); br.close();
    }
}
