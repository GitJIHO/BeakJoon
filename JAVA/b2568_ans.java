import java.util.*;
import java.io.*;

public class b2568_ans {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<int[]> lines;
    static int[] lisIndex;
    static int N, result;
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        lines = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            lines.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }
        
        Collections.sort(lines, Comparator.comparingInt(a -> a[0]));
        lisIndex = new int[N];
    }

    static void dp() {
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int num = lines.get(i)[1];
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);

            if (pos == lis.size()) lis.add(num);
            else lis.set(pos, num);

            lisIndex[i] = pos;
        }

        result = N - lis.size();
    }

    static void result() throws IOException {
        bw.write(result + "\n");
        
        Set<Integer> lisSet = new HashSet<>();
        int pos = Arrays.stream(lisIndex).max().getAsInt();

        for (int i = N - 1; i >= 0; i--) {
            if (lisIndex[i] == pos) {
                lisSet.add(lines.get(i)[1]);
                pos--;
            }
        }

        for (int[] line : lines) {
            if (!lisSet.contains(line[1])) {
                bw.write(line[0] + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dp();
        result();
        bw.flush();
        bw.close();
        br.close();
    }
}
