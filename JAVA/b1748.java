import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1748 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long num = Long.parseLong(br.readLine());
        long res = 0;
        
        for(long i = 1; i <= num; i *= 10) {
            res += (num - i + 1);
        }

        bw.write(Long.toString(res));
        bw.flush();
        br.close();
    }
}