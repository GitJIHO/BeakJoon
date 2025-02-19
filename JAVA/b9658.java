import java.io.*;
import java.util.*;

public class b9658 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void cal() throws IOException {
        if (N % 7 == 1 || N % 7 == 3) {
            bw.write("CY");
        } else {
            bw.write("SK");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}