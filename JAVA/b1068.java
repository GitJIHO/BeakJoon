import java.util.*;
import java.io.*;

public class b1068 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, target;
    static ArrayList<ArrayList<Integer>> tree;
    static int result;
    static int root;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i=0; i<N; i++) {
            tree.add(new ArrayList<>());
        }
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            int node = Integer.parseInt(input[i]);
            if (node == -1) {
                root = i;
                continue;
            }
            tree.get(node).add(i);
        }
        target = Integer.parseInt(br.readLine());
    }

    static void dfs(int node) {
        if (node == target) return;
        
        boolean isLeaf = true;
        
        for (int i : tree.get(node)) {
            if (i == target) continue;
            isLeaf = false;
            dfs(i);
        }

        if (isLeaf) {
            result++;
        }
    }

    static void result() throws IOException {
        if (target == root) {
            result = 0;
        } else {
            dfs(root);
        }
        bw.write(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException {
        input();
        result();
        bw.flush();
        bw.close(); br.close();                
    }
}
