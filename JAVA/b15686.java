import java.util.*;
import java.io.*;

public class b15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<int[]> chickens;
    static ArrayList<int[]> houses;
    static boolean[] open;
    static int N, M, result;
    static int MAX_VALUE = 20000000;

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                int val = Integer.parseInt(input[j]);
                if (val == 1) {
                    houses.add(new int[] {i+1, j+1});
                }
                if (val == 2) {
                    chickens.add(new int[] {i+1, j+1});
                }
            }
        }

        open = new boolean[chickens.size()];
        result = MAX_VALUE;
    }


    static void dfs(int start, int cnt) throws IOException {
        if (cnt == M) {
            int cdis = 0;
            for (int[] house : houses) {
                int min = MAX_VALUE;
                
                for (int i=0; i<chickens.size(); i++) {
                    if (open[i]) {
                        int[] chicken = chickens.get(i);

                        int hx = house[0];
                        int hy = house[1];
                        int cx = chicken[0];
                        int cy = chicken[1];

                        int dis = Math.abs(cx - hx) + Math.abs(cy - hy);
                        min = Math.min(min, dis);
                    }  
                }
                cdis += min;
            }
            result = Math.min(result, cdis);
            return;
        }
        
        for (int i=start; i<chickens.size(); i++) {
            open[i] = true;
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(0,0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close(); br.close();
    }
}