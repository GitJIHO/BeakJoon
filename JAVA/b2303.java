import java.io.*;
import java.util.*;

public class b2303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] cards;
    static int maxValue = -1;
    static int winner = 0;
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N][5];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
    
    static void cal() {
        for (int i = 0; i < N; i++) {
            int max = getMaxDigit(i);
            
            if (max >= maxValue) {
                maxValue = max;
                winner = i + 1;
            }
        }
    }
    
    static int getMaxDigit(int person) {
        int max = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int sum = cards[person][i] + cards[person][j] + cards[person][k];
                    int digit = sum % 10;
                    max = Math.max(max, digit);
                }
            }
        }
        
        return max;
    }
    
    static void result() throws IOException {
        bw.write(String.valueOf(winner));
    }
    
    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
