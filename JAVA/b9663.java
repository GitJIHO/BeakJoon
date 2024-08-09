import java.io.*;

public class b9663 {

    static int N;
    static int[] col;
    static int res = 0;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];

        br.close();
    }

    static boolean valid(int x1, int y1, int x2, int y2) {
        if (y1 == y2)
            return false;
        if (x1 + y1 == x2 + y2)
            return false;
        if (x1 - y1 == x2 - y2)
            return false;
        return true;
    }

    static void rec(int row) {
        if (row == N + 1) {
            res++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean possible = true;
                for(int j=1;j<=row-1;j++) {
                    if(!valid(row, i, j, col[j])){
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    col[row] = i;
                    rec(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec(1);
        System.out.println(res);
    }
}