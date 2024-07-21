import java.io.*;

public class b1008 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        double a;
        double b;

        a = Double.parseDouble(input[0]);
        b = Double.parseDouble(input[1]);

        bw.write(String.valueOf(a/b));
        bw.flush();
        bw.close(); br.close();
    }
}
