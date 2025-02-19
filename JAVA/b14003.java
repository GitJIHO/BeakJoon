import java.util.*;
import java.io.*;

public class b14003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static int[] index;
    static ArrayList<Integer> list;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        index = new int[N];
        list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static void cal() {
        list.add(Integer.MIN_VALUE);
        
        for (int i=0; i<N; i++) {
            int left = 0;
            int right = list.size() - 1;
            if (arr[i] <= list.get(list.size() - 1)) {
                while (left < right) {
                    int mid = (left + right) / 2;
                    
                    if (list.get(mid) < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, arr[i]);
                index[i] = right;
            } else {
                list.add(arr[i]);
                index[i] = list.size() - 1;
            }
        }
    }


    static void result() throws IOException {
        int size = list.size() - 1;
        bw.write(size + "\n");
        
        Stack<Integer> stack = new Stack<>();
        int idx = size;
        for (int i=N-1; i>=0; i--) {
            if (index[i] == idx) {
                stack.push(arr[i]);
                idx--;
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        cal();
        result();
        bw.flush();
        bw.close(); br.close();
    }
}
