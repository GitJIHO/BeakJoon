import java.io.*;

public class b10869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int a;
        int b;

        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        bw.write((a+b)+"\n"+(a-b)+"\n"+(a*b)+"\n"+(a/b)+"\n"+(a%b)+"\n");

        bw.flush();
        bw.close(); br.close();
    }
}
