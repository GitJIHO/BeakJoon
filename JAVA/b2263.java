import java.util.*;
import java.io.*;

public class b2263 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] pre;
    static int[] post;
    static int[] in;
    static int index;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pre = new int[N];
        post = new int[N];
        in = new int[N];
        index = 0;
        
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            in[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            post[i] = Integer.parseInt(input[i]);
        }
    }

    static void calPreOrder(int ins, int ine, int posts, int poste) {
        if (ins <= ine && posts <= poste) {

            pre[index++] = post[poste];

            int parent = ins;
            for (int i=ins; i<=ine; i++) {
                if (in[i] == post[poste]) {
                    parent = i;
                    break;
                }
            }

            calPreOrder(ins, parent-1, posts, posts+parent-ins-1);
            calPreOrder(parent+1, ine, posts+parent-ins, poste-1);
        }
        return;
    }

    static void result() throws IOException {
        for (int i : pre) {
            bw.write(String.valueOf(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        calPreOrder(0, N-1, 0, N-1);
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
