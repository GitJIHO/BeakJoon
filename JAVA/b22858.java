import java.io.*;

public class b22858 {

    static int N;
    static int K;
    static int[] S;
    static int[] D;
    static int[] result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        S = new int[N+1];
        D = new int[N+1];
        result = new int[N+1];
        String[] Sinput = br.readLine().split(" ");
        for(int i=1; i<=N; i++) { 
            S[i] = Integer.parseInt(Sinput[i-1]);
        }
        String[] Dinput = br.readLine().split(" ");
        for(int i=1; i<=N; i++) { 
            D[i] = Integer.parseInt(Dinput[i-1]);
        }
    }

    static void cal() throws IOException {
        for(int i=0; i<K; i++) {
            spin();
        }
        for(int i=1; i<=N; i++) {
            bw.write(result[i] + " ");
        }
    }

    static void spin() {
        for(int i=1; i<=N; i++) {
            result[D[i]] = S[i];
        }
        S = result.clone();
    }

    public static void main(String[] args) throws IOException{
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}
