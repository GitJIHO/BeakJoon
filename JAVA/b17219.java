import java.io.*;
import java.util.*;

public class b17219 {

    static int N;
    static int M;
    static Map<String, String> map = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void input() throws IOException{
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        for(int i=0; i<N; i++){
            temp = br.readLine().split(" ");
            map.put(temp[0], temp[1]);
        }
        for(int i=0; i<M; i++){
            bw.write(map.get(br.readLine()) + "\n");
        }
    }
    
    public static void main(String[] args) throws IOException{
        input();
        bw.flush();
        bw.close();
        br.close();
    }
}
