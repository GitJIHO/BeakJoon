import java.util.Arrays;
import java.util.Scanner;

public class b1920 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            
            int N = sc.nextInt();
            int[] A = new int[N];
            
            for (int i = 0; i < A.length; i++) {
                A[i] = sc.nextInt();
            }
            
            int M = sc.nextInt();
            
            Arrays.sort(A);
            
            for (int i = 0; i < M; i++) {
                if (binarySearch(A, sc.nextInt()) >= 0) {
                    sb.append(1).append("\n");
                } else sb.append(0).append("\n");
            }
            
            System.out.println(sb);
        }
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(target == arr[mid]){
                return 0;
            }
            else if(target < arr[mid]){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return -1;
    }
}