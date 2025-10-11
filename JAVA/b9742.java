import java.io.*;
import java.util.*;

public class b9742 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int totalCount, num;
    static boolean visit[];
    static char[] chars;
    static String answer;
    static boolean found;

    static void dfs(String str, int cnt) {
        if(found) return;
        
        if(cnt==str.length()){
            totalCount++;
            if(totalCount==num) {
                answer=new String(chars);
                found = true;
            }
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(!visit[i] && !found){
                visit[i]=true;
                chars[cnt]=str.charAt(i);
                dfs(str, cnt+1);
                visit[i]=false;
            }
        }
    }

    static void cal() throws IOException {
        String line;

        while((line=br.readLine())!=null && !line.isEmpty()){
            StringTokenizer st = new StringTokenizer(line);
            String str = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            totalCount=0;
            chars=new char[str.length()];
            visit=new boolean[str.length()];
            answer="No permutation";
            found=false;

            dfs(str, 0);

            bw.write(str+" "+num+" = "+answer+"\n");
        }
    }

    public static void main(String[] args) throws IOException {
        cal();
        bw.flush();
        bw.close(); br.close();
    }
}