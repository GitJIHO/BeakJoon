import java.io.*;
import java.util.*;

public class b7785 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Set<String> company = new HashSet<>();
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];
            
            if (status.equals("enter")) {
                company.add(name);
            } else {
                company.remove(name);
            }
        }
    }
    
    static void result() throws IOException {
        List<String> list = new ArrayList<>(company);
        Collections.sort(list, Collections.reverseOrder());
        
        for (String name : list) {
            bw.write(name + "\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
