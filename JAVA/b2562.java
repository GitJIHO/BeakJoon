import java.util.*;
import java.io.*;

public class b2562 {
    
    static Map<Integer, Integer> map = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static void input() throws IOException{
        for(int i=1; i<=9; i++) {
            int N = Integer.parseInt(br.readLine());
            map.put(i, N);
        }
    }

    static void result() throws IOException{
        int max = 0;
        int result = 0;
        for(int i=1; i<=9; i++) {
            if (max < map.get(i)) {
                max = map.get(i);
                result = i;
            }
        }
        bw.write(max + "\n" + result);
    }
    public static void main(String[] args) throws IOException{
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
