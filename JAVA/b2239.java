import java.util.*;
import java.io.*;

public class b2239 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr =new int[9][9];
	static boolean flag;

    static void input() throws IOException {
        for (int i=0; i<9; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    static void dfs(int d) {
		if(d==81) {
			flag = true;
			return;
		}
	
		int r = d/9;
		int c = d%9;
		
		if(arr[r][c]!=0)
			dfs(d+1);
		else {
			for(int i=1;i<10;i++) {
				if(!isValid(r,c,i)) continue;
				arr[r][c] = i;
				dfs(d+1);
				if(flag) return;
				arr[r][c]=0;
			}
		}		
	}

	static boolean isValid(int r, int c, int n) {
		for(int i=0;i<9;i++) {
			if(arr[i][c]==n || arr[r][i]==n) return false;
		}

		int sr = r/3 * 3;
		int sc = c - c%3;
		for(int row=sr;row<sr+3;row++) {
			for(int col=sc;col<sc+3;col++) {
				if(arr[row][col]==n) return false;
			}
		}
		
		return true;
	}

    static void result() throws IOException {
        for (int i[] : arr) {
            for (int j : i) {
                bw.write(String.valueOf(j));
            }
            bw.write("\n");
        }
    }

	public static void main(String[] args) throws IOException {	
        input();		
		dfs(0);
		result();
        bw.flush();
        bw.close(); br.close();
	}
}
