import java.io.*;
import java.util.*;

public class b11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) break;
            if (coins[i] <= k) {
                count += k / coins[i];
                k %= coins[i];
            }
        }
        
        System.out.println(count);
    }
}