import java.io.*;

public class b10809 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;
    static int[] result = new int[26];

    static void input() throws IOException {
        word = br.readLine();
        for (int i=0; i<26; i++) {
            result[i] = -1;
        }
    }

    static void cal() throws IOException {
        char[] check = word.toCharArray();
        for (int i=0; i<check.length; i++) {
            int c = Integer.valueOf(check[i]) - 97;
            if (result[c] == -1) {
                result[c] = i;
            }
        }
    }

    static void result() throws IOException {
        for (int i : result) {
            bw.write(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
