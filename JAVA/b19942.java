import java.util.*;
import java.io.*;

public class b19942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    static int[] min_nutrution;
    static int[] isSelected;
    static List<String> list;

    static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][5];
        min_nutrution = new int[4];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min_nutrution[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            isSelected = new int[i];
            dfs(0, i, 1);
        }
    }

    static void dfs(int cnt, int choiceNum, int start) {
        if (cnt == choiceNum) {
            checkNutrition(choiceNum);
            return;
        }

        for (int i = start; i <= N; i++) {
            isSelected[cnt] = i;
            dfs(cnt + 1, choiceNum, i + 1);
        }
    }

    static void checkNutrition(int choiceNum) {
        int[] sum_nutrition = new int[4];
        int price = 0;

        for (int i = 0; i < choiceNum; i++) {
            for (int j = 0; j < 4; j++) {
                sum_nutrition[j] += arr[isSelected[i]][j];
            }
            price += arr[isSelected[i]][4];
        }

        for (int i = 0; i < 4; i++) {
            if (sum_nutrition[i] < min_nutrution[i]) {
                return;
            }
        }

        if (result >= price) {
            if (result > price) {
                list.clear();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < choiceNum; i++) {
                sb.append(isSelected[i]).append(" ");
            }
            list.add(sb.toString().trim());
            result = price;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.write(String.valueOf(result));
        if (result != Integer.MAX_VALUE) {
            Collections.sort(list);
            bw.newLine();
            bw.write(list.get(0));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
