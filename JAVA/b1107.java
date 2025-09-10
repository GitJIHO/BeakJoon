import java.util.*;
import java.io.*;

public class b1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int target, N, count;
    static int[] dead;
    
    static void input() throws IOException {
        target = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        dead = new int[N];
        if (N > 0) {
            String[] input = br.readLine().split(" ");
            for (int i=0; i<N; i++) {
                dead[i] = Integer.parseInt(input[i]);
            }
        }
    }

static void cal() {
    count = Math.abs(target - 100);

    for (int ch = 0; ch <= 999999; ch++) {
        if (canPress(ch)) {
            int pressCount = String.valueOf(ch).length();
            pressCount += Math.abs(target - ch);
            count = Math.min(count, pressCount);
        }
    }
}

static boolean canPress(int ch) {
    if (ch == 0) {
        for (int d : dead) {
            if (d == 0) return false;
        }
        return true;
    }

    while (ch > 0) {
        int digit = ch % 10;
        for (int d : dead) {
            if (digit == d) return false;
        }
        ch /= 10;
    }
    return true;
}

    public static void main(String[] args) throws IOException {
        input();
        cal();
        bw.write(String.valueOf(count));
        bw.close(); br.close();
    }
}