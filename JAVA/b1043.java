import java.io.*;

public class b1043 {

    static int N;
    static int M;
    static int[] liar;
    static boolean[][] graph;
    static int[][] member;
    static int count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        liar = new int[n];
        graph = new boolean[N+1][N+1];
        member = new int[M][51];
        for(int i=0; i<n; i++) {
            liar[i] = Integer.parseInt(input[i+1]);
        }
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            for(int k=0; k<input.length; k++) {
                member[i][k] = Integer.parseInt(input[k]);
            }
            int m = Integer.parseInt(input[0]);
            if(m == 1) {
                int index = Integer.parseInt(input[1]);
                graph[index][index] = true;
            } else {
                for(int j=1; j<m; j++) {
                    graph[Integer.parseInt(input[j])][Integer.parseInt(input[j+1])] = true;
                }
            }
        }
    }

    static void delete() {
        for(int index : liar) {
            makeFalse(index);
        }
    }

    static void makeFalse(int index) {
        for(int i=1; i<=N; i++) {
            if(graph[index][i] == true) {
                graph[index][i] = false;
                makeFalse(i);
            }
            if(graph[i][index] == true) {
                graph[i][index] = false;
                makeFalse(i);
            }
        }
    }

    static void result() throws IOException {
        count = 0;
        boolean check;
        for(int i=0; i<M; i++) {
            check = true;
            if(member[i][0] == 1) {
                int n = member[i][1];
                if(graph[n][n]) {
                    count++;
                }
                check = false;
            } else {
                for(int j=1; j<member[i][0]; j++) {
                    if(!graph[member[i][j]][member[i][j+1]]) {
                        check = false;
                        break;
                    }
                }
            }
            if(check) {
                count++;
            }
        }
        bw.write(String.valueOf(count));
    }

    public static void main(String[] args) throws IOException {
        input();
        delete();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
