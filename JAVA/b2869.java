import java.util.*;
import java.io.*;

public class b2869 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int A, B, V;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf((int) Math.ceil((double)(V-A) / (A-B)) + 1));
        bw.flush();
        bw.close(); br.close();
    }
}