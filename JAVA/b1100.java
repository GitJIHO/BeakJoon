import java.io.*;

public class b1100 {   

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int res = 0;

        String mat[][] = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String arr = br.readLine();
            for (int j = 0; j < 8; j++) {
                mat[i][j] = String.valueOf(arr.charAt(j));
            }
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                if((i+j)%2==0 && mat[i][j].equals("F")) res++;
            }
        }
        
        bw.write(Integer.toString(res));
        // bw.write(String.valueOf(res));
        bw.flush();
        bw.close(); br.close();
    }
}
