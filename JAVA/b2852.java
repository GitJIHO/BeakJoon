import java.io.*;

public class b2852 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int score1 = 0, score2 = 0;
    static int leadTime1 = 0, leadTime2 = 0;
    static int lastTime = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);
            int curTime = parseSec(input[1]);

            if (score1 > score2) {
                leadTime1 += (curTime - lastTime);
            } else if (score2 > score1) {
                leadTime2 += (curTime - lastTime);
            }

            if (team == 1) score1++;
            else score2++;

            lastTime = curTime;
        }

        int endTime = 48 * 60;
        if (score1 > score2) {
            leadTime1 += (endTime - lastTime);
        } else if (score2 > score1) {
            leadTime2 += (endTime - lastTime);
        }

        bw.write(parseMinSec(leadTime1) + "\n");
        bw.write(parseMinSec(leadTime2) + "\n");
        bw.flush();
        bw.close(); br.close();
    }

    static int parseSec(String st) {
        String[] parts = st.split(":");
        int m = Integer.parseInt(parts[0]);
        int s = Integer.parseInt(parts[1]);
        return m * 60 + s;
    }

    static String parseMinSec(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
}
