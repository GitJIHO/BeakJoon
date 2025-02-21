import java.io.*;
import java.util.*;

public class b1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        
        int[] count = new int[26];
        for (char c : name.toCharArray()) {
            count[c - 'A']++;
        }

        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder front = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                front.append((char) (i + 'A'));
            }
        }

        String palindrome = front.toString();
        String result = palindrome + (oddCount == 1 ? oddChar : "") + front.reverse();
        System.out.println(result);
    }
}
