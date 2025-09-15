import java.io.*;

public class b1662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] splitStr;
    static int idx;

    static int StrLength(int start) {
        int len = 0;
        for (int i = start; i < splitStr.length; i++) {
            if (splitStr[i].equals("(")) {
                len += Integer.parseInt(splitStr[i - 1]) * StrLength(i + 1) - 1;
                i = idx;
            } else if (splitStr[i].equals(")")) {
                idx = i;
                return len;
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        splitStr = br.readLine().split("");
        int ans = StrLength(0);
        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
