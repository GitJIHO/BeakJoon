import java.io.*;
import java.util.*;

public class b2477 {

    static int K;
    static int hMax = 0, wMax = 0;
    static int hMaxIdx = -1, wMaxIdx = -1;
    static int[] dirs = new int[6];
    static int[] dist = new int[6];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dirs[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());

            if (dirs[i] == 1 || dirs[i] == 2) {
                if (hMax < dist[i]) {
                    hMax = dist[i];
                    hMaxIdx = i;
                }
            } else {
                if (wMax < dist[i]) {
                    wMax = dist[i];
                    wMaxIdx = i;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        int maxSquare = wMax * hMax;
        int minSquare = dist[(wMaxIdx + 3) % 6] * dist[(hMaxIdx + 3) % 6];

        System.out.println((maxSquare - minSquare) * K);
    }
}
