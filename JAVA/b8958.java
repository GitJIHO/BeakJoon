import java.io.*;

public class b8958 {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int result = 0;
            int plus = 0;
            String[] input = br.readLine().split("");
            for(String s : input) {
                if(s.equals("O")) {
                    result += ++plus;
                } else {
                    plus = 0;
                }
            }
            bw.write(String.valueOf(result) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();            
    }
}
