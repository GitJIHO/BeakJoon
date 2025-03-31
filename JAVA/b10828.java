import java.io.*;
import java.util.*;

public class b10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }
        
        System.out.println(sb.toString());
    }
    
    static class Stack {
        private int[] stack;
        private int size;
        
        public Stack() {
            stack = new int[10000];
            size = 0;
        }
        
        public void push(int x) {
            stack[size++] = x;
        }
        
        public int pop() {
            if (size == 0) {
                return -1;
            }
            return stack[--size];
        }
        
        public int size() {
            return size;
        }
        
        public int empty() {
            return size == 0 ? 1 : 0;
        }
        
        public int top() {
            if (size == 0) {
                return -1;
            }
            return stack[size - 1];
        }
    }
}