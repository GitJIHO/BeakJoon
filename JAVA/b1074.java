import java.io.*;

public class b1074 {
    static int N, r, c;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        r = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);
        
        solve((int)Math.pow(2, N), 0, 0);
        System.out.println(result);
    }

    static void solve(int size, int row, int col) {
        if (size == 1) {
            return;
        }

        int newSize = size / 2;
        int areaSize = newSize * newSize;

        // 1사분면
        if (r < row + newSize && c < col + newSize) {
            solve(newSize, row, col);
        }
        // 2사분면
        else if (r < row + newSize && c >= col + newSize) {
            result += areaSize;
            solve(newSize, row, col + newSize);
        }
        // 3사분면
        else if (r >= row + newSize && c < col + newSize) {
            result += 2 * areaSize;
            solve(newSize, row + newSize, col);
        }
        // 4사분면
        else {
            result += 3 * areaSize;
            solve(newSize, row + newSize, col + newSize);
        }
    }
}
