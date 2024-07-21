import java.io.*;

public class b2438 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a;

        a = Integer.parseInt(br.readLine());

        for(int i=1; i<=a; i++){
            bw.write("*".repeat(i) + "\n");
        }

        bw.flush();
        bw.close(); br.close();
    }
}
