import java.io.*;
import java.util.*;

public class b19699 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] weights;
    static Set<Integer> primes = new TreeSet<>();
    
    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        weights = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(input[i]);
        }
    }
    
    static void combination(int idx, int cnt, int sum) {
        if (cnt == M) {
            if (isPrime(sum)) {
                primes.add(sum);
            }
            return;
        }
        
        for (int i = idx; i < N; i++) {
            combination(i + 1, cnt + 1, sum + weights[i]);
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    static void result() throws IOException {
        if (primes.isEmpty()) {
            bw.write("-1\n");
        } else {
            for (int prime : primes) {
                bw.write(prime + " ");
            }
            bw.write("\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        combination(0, 0, 0);
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
