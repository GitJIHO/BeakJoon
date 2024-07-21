import java.io.*;

public class b1330 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int a;
        int b;

        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        if(a>b) bw.write(">");
        else if(a<b) bw.write("<");
        else bw.write("==");

        bw.flush();
        bw.close(); br.close();
    }
}
