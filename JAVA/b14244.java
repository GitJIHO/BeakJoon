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
        bw.write("0 1\n");
        for (int i=1; i < M; i++) {
            bw.write(1 + " " + String.valueOf(i+1) + "\n");
        }
        for (int i=M; i < N - 1; i++) {
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