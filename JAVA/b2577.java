import java.io.*;

public class b2577 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int num;
    static int[] result;

    static void input() throws IOException {
        num = 1;
        for (int i=0; i<3; i++) {
            num *= Integer.parseInt(br.readLine());
        }
    }

    static void cal() throws IOException {
        String number = String.valueOf(num);
        String[] split = number.split("");
        result = new int[10];
        for (String s : split) {
            switch (s) {
                case "0" : result[0]++; break;
                case "1" : result[1]++; break;
                case "2" : result[2]++; break;
                case "3" : result[3]++; break;
                case "4" : result[4]++; break;
                case "5" : result[5]++; break;
                case "6" : result[6]++; break;
                case "7" : result[7]++; break;
                case "8" : result[8]++; break;
                case "9" : result[9]++; break;
                default : break;
            }
        }
        for (int r : result) {
            bw.write(String.valueOf(r) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}
