import java.io.*;

public class b9291 {

    static int[][] mat;
    static String[] row;
    static String[] col;
    static int r;
    static int c;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void input() throws IOException {
        row = br.readLine().split("");
        col = br.readLine().split("");
        r = row.length;
        c = col.length;
        mat = new int[r+1][c+1];       
    }

    static void find() throws IOException {
        for(int i=1; i<=c; i++) {
            String s = col[i-1];
            for(int j=1; j<=r; j++) {
                if(row[j-1].equals(s)) {
                    mat[j][i] = mat[j-1][i-1] + 1;
                } else {
                    mat[j][i] = Math.max(mat[j-1][i], mat[j][i-1]);
                }            
            }
        }
        bw.write(mat[r][c]+ "");
    }

    public static void main(String[] args) throws IOException {
        input();
        find();
        bw.flush();
        bw.close(); br.close();
    }
}
