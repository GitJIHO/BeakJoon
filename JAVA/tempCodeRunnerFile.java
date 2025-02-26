import java.io.*;

public class b14244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
    }

    static void cal() throws IOException {
        int index;
        for (int i=0; i < M - 1; i++) {
            bw.write(0 + " " + String.valueOf(i+1) + "\n");
        }
        for (int i=M - 1; i < N - 1; i++) {
            bw.write(i + " " + String.valueOf(i+1) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}