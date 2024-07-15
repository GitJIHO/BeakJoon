import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15665 {
   
   static StringBuilder sb = new StringBuilder();
   static int[] arr;
   static int[] nums;
   static int N,M;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      arr = new int[M];
      nums = new int[N];
      
      st = new StringTokenizer(br.readLine()," ");
       
      for(int i=0;i<N;i++) {
         nums[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(nums);
      dfs(0);
      System.out.println(sb);
   }
   
   public static void dfs(int depth) {
      if(depth==M) {
         for(int i=0;i<M;i++) {
            sb.append(arr[i]).append(" ");
         }
         sb.append("\n");
         return;
      } else { // 중복된 수열들을 출력하면 안된다.
         int before=0;
         for(int i=0;i<N;i++) {
            if(before!=nums[i]) {
               arr[depth]=nums[i];
               before=nums[i];
               dfs(depth+1);
         
            }
         }
      }
   }
   
}