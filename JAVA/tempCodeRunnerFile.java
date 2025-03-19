import java.util.*;
import java.io.*;

public class b9328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static char[][] map;
    static Set<Character> keys;
    static int h, w, result;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    static void input() throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            h = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);

            visited = new boolean[h][w];
            map = new char[h][w];
            keys = new HashSet<Character>();
            
            for (int i=0; i<h; i++) {
                String line = br.readLine();
                for (int j=0; j<w; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            line = br.readLine();
            for (int i=0; i<line.length; i++) {
                keys.add(line.charAt(i));
            }

            result();
        }
    }

    static void result() throws IOException {
        for (char[] i : map) {
            for (char j : i) {
                bw.write(j);
            }
            bw.write("\n");
        }
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}