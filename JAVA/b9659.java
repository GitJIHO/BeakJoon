import java.io.*;
import java.util.*;

public class b9659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long N;
    static Long num = 1000000000000L;

    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
        N %= num;
    }

    static void cal() throws IOException {
        if (N % 2 == 0) {
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