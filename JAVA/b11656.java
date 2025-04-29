import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        String[] suffixes = new String[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            suffixes[i] = s.substring(i);
        }
        
        Arrays.sort(suffixes);
        
        for (String suffix : suffixes) {
            System.out.println(suffix);
        }
        
        br.close();
    }
}