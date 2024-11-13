import java.util.*;
import java.io.*;

public class b11725 {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] tree;
    static int[] parent;
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i=0; i<N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree[a].add(b);
            tree[b].add(a);
        }
    }

    static void dfs(int key){
        for (int i : tree[key]) {
            if (parent[i] == 0) {
                parent[i] = key;
                dfs(i);
            }
        }
        return;
    }

    static void print() throws IOException {
        for (int i=2; i<=N; i++) {
            bw.write(String.valueOf(parent[i]) + "\n");
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        dfs(1);
        print();
        bw.flush();
        bw.close(); br.close();
        
    }
}
