import java.io.*;

public class b1629 {

    static Long A;
    static Long B;
    static Long C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        C = Long.parseLong(input[2]);
    }

    static Long cal(Long a, Long b, Long c) throws IOException {
        if (b == 1) return a % c;

        long temp = cal(a, b/2, c) % c;

        if (b % 2 == 0){
            return (temp * temp)% c;
        }
        else return (temp * (cal(a, b/2 + b%2, c) % c)) % c;
    }

    public static void main(String[] args) throws IOException{
        input();
        bw.write(String.valueOf(cal(A,B,C)));
        bw.flush();
        bw.close(); br.close();
    }
}
