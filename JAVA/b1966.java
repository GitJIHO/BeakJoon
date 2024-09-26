import java.io.*;
import java.util.*;

public class b1966 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);
            
            String[] secondLine = br.readLine().split(" ");
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(secondLine[i]);
                queue.add(new int[]{i, priority});
                priorityQueue.add(priority);
            }

            int printOrder = 0;
            
            while (!queue.isEmpty()) {
                int[] currentDoc = queue.poll();
                int currentIndex = currentDoc[0];
                int currentPriority = currentDoc[1];
                
                if (currentPriority == priorityQueue.peek()) {
                    printOrder++;
                    priorityQueue.poll();
                    
                    if (currentIndex == M) {
                        bw.write(printOrder + "\n");
                        break;
                    }
                } else {
                    queue.add(currentDoc);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
