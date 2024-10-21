import java.io.*;

public class b24314 {

    static int a1;
    static int a0;
    static int c;
    static int n0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        a1 = Integer.parseInt(input[0]);
        a0 = Integer.parseInt(input[1]);
        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());
    }

    static boolean cal() {
        if (a1 < c) {
            return false;
        }
        return c * n0 <= a1 * n0 + a0;
    }

    static void result() throws IOException {
        if (cal()) {
            bw.write(String.valueOf(1));
            return;
        }
        bw.write(String.valueOf(0));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
