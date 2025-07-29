import java.io.*;
import java.util.*;

public class b11655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stb = new StringBuilder();

    static void input() throws IOException {
        String line = br.readLine();
        for (char ch : line.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                stb.append((char) ((ch - 'A' + 13) % 26 + 'A'));
            } else if ('a' <= ch && ch <= 'z') {
                stb.append((char) ((ch - 'a' + 13) % 26 + 'a'));
            } else {
                stb.append(ch);
            }
        }
    }

    static void print() throws IOException {
        bw.write(String.valueOf(stb));
    }

    public static void main(String[] args) throws IOException {
        input();
        print();
        bw.flush();
        bw.close(); br.close();
    }
}
