import java.io.*;

public class b2630 {

    static int blue = 0;
    static int white = 0;
    static int[][] mat;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                mat[i][j] = Integer.parseInt(arr[j]);
            }
        }

        check(0, N - 1, 0, N - 1);

        bw.write(Integer.toString(white) + "\n");
        bw.write(Integer.toString(blue));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void check(int w1, int w2, int h1, int h2) {

        boolean isSingleColor = true;
        int firstColor = mat[h1][w1];

        for (int i = h1; i <= h2; i++) {
            for (int j = w1; j <= w2; j++) {
                if (mat[i][j] != firstColor) {
                    isSingleColor = false;
                    break;
                }
            }
            if (!isSingleColor) {
                break;
            }
        }

        if (isSingleColor) {
            if (firstColor == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            int midH = (h1 + h2) / 2;
            int midW = (w1 + w2) / 2;

            check(w1, midW, h1, midH); // 왼쪽 위
            check(midW + 1, w2, h1, midH); // 오른쪽 위
            check(w1, midW, midH + 1, h2); // 왼쪽 아래
            check(midW + 1, w2, midH + 1, h2); // 오른쪽 아래
        }
    }
}