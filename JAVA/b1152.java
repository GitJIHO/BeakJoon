import java.io.*;
import java.util.*;

public class b1152 {
    static void input() throws IOException{
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine().trim();

        if(st.isEmpty()) {
            System.out.println('0');
        } else {
            System.out.println(st.split(" ").length);
        }

        sc.close();
    }

    public static void main(String[] args) throws IOException{
        input();
    }
}
