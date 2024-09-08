import java.io.*;
import java.util.*;

public class b2439 {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void draw() throws IOException {
        String s = "*";
        String b = " ";

        for(int i=0; i<N; i++) {
            for(int j=0; j<N-i-1; j++) {
                bw.write(b);
            }
            for(int k = 0; k<i+1; k++){
                bw.write(s);
            }
            bw.write("\n");
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        draw();
        bw.flush();
        bw.close(); br.close();
    }
}
