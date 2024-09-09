import java.io.*;

public class b16953 {

    static int N;
    static int M;
    static int result = 0;
    static boolean r = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
    }

    static void cal(int number) throws IOException {
        if(number == N) {
            bw.write(String.valueOf(result + 1));
            r = true;
        }
        if(number < N){
            return;
        }
        if(number % 10 == 1) {
            result++;
            cal(number/10);
            result--;
        }
        if(number % 2 == 0) {
            result++;
            cal(number/2);
            result--;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal(M);
        if(!r) {
            bw.write("-1");
        }
        bw.flush();
        bw.close(); br.close();
    }
}
