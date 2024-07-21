import java.io.*;

public class b2739 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a;

        a = Integer.parseInt(br.readLine());

        for(int i=1; i<=9; i++){
            bw.write(a+" * "+i+" = "+(a*i)+"\n");
        }

        bw.flush();
        bw.close(); br.close();
    }
}
