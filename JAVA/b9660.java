import java.io.*;
import java.util.*;

public class b9660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long N;

    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
    }

    static void cal() throws IOException {
        if (N % 7 == 0 || N % 7 == 2) {
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