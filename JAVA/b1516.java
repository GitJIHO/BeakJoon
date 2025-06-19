import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Building implements Comparable<Building> {
    int num;
    int time;
 
    Building(int num, int time) {
        this.num = num;
        this.time = time;
    }
 
    @Override
    public int compareTo(Building arg0) {
        return time - arg0.time;
    }
}
 
public class b1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
 
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }
 
        int[] indegree = new int[N + 1];
        Building[] buildings = new Building[N + 1];
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
 
            int time = Integer.parseInt(st.nextToken());
            buildings[i] = new Building(i, time);
 
            while (true) {
                int num = Integer.parseInt(st.nextToken());
 
                if (num == -1) {
                    break;
                }
 
                a.get(num).add(i);
 
                indegree[i]++;
            }
        }
 
        String ans = topologicalSort(a, indegree, buildings, N);
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static String topologicalSort(ArrayList<ArrayList<Integer>> a, int[] indegree, Building[] buildings, int N) {
        PriorityQueue<Building> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(buildings[i]);
            }
        }
 
        while (!pq.isEmpty()) {
            int now = pq.poll().num;
 
            for (int next : a.get(now)) {
                indegree[next]--;
 
                if (indegree[next] == 0) {
                    buildings[next].time += buildings[now].time;
                    pq.offer(new Building(next, buildings[next].time));
                }
            }
        }
 
        for (int i = 1; i <= N; i++) {
            sb.append(buildings[i].time + "\n");
        }
 
        return sb.toString();
    }
}