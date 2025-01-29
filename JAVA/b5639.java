import java.io.*;

class Node {
    int num;
    Node left;
    Node right;

    public Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }
}

public class b5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Node root;

    static void input() throws IOException {
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int input = Integer.parseInt(line);
            
            if (root == null) {
                root = new Node(input, null, null);
            } else {
                makeTree(root, input);
            }
        }
    }

    static void makeTree(Node node, int value) {
        if (value < node.num) {
            if (node.left == null) {
                node.left = new Node(value, null, null);
            } else {
                makeTree(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value, null, null);
            } else {
                makeTree(node.right, value);
            }
        }
    }

    static void postOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        bw.write(String.valueOf(node.num) + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        postOrder(root);
        bw.flush();
        bw.close(); br.close();
    }
}
