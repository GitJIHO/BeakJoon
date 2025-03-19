import java.util.*;
import java.io.*;

public class b9328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static char[][] map;
    static Set<Character> keys;
    static int h, w, result;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    static void input() throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            h = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);

            result = 0;
            visited = new boolean[h][w];
            map = new char[h][w];
            keys = new HashSet<Character>();
            
            for (int i=0; i<h; i++) {
                String line = br.readLine();
                for (int j=0; j<w; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            String line = br.readLine();
            if (!line.equals("0")) {
                for (int i=0; i<line.length(); i++) {
                keys.add(line.charAt(i));
                }
            }
            
            bfs();
            bw.write(String.valueOf(result) + "\n");
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        while (true) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if ((i == 0 || j == 0 || i == h - 1 || j == w - 1) && !visited[i][j]) {
                        if (map[i][j] == '.') {
                            queue.add(new int[]{i, j});
                            visited[i][j] = true;
                        } else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
                            keys.add(map[i][j]);
                            map[i][j] = '.';
                            queue.add(new int[]{i, j});
                            visited[i][j] = true;
                        } else if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
                            if (keys.contains(Character.toLowerCase(map[i][j]))) {
                                map[i][j] = '.';
                                queue.add(new int[]{i, j});
                                visited[i][j] = true;
                            }
                        } else if (map[i][j] == '$') {
                            result++;
                            map[i][j] = '.';
                            queue.add(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
            }

            boolean foundNewKey = false;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                for (int i = 0; i < 4; i++) {
                    int curx = row + dx[i];
                    int cury = col + dy[i];

                    if (curx >= 0 && curx < h && cury >= 0 && cury < w && !visited[curx][cury]) {
                        visited[curx][cury] = true;

                        if (map[curx][cury] == '.') {
                            queue.add(new int[]{curx, cury});
                        } else if (map[curx][cury] == '$') {
                            result++;
                            map[curx][cury] = '.';
                            queue.add(new int[]{curx, cury});
                        } else if (map[curx][cury] >= 'a' && map[curx][cury] <= 'z') {
                            keys.add(map[curx][cury]);
                            map[curx][cury] = '.';
                            queue.add(new int[]{curx, cury});
                            foundNewKey = true;
                        } else if (map[curx][cury] >= 'A' && map[curx][cury] <= 'Z') {
                            if (keys.contains(Character.toLowerCase(map[curx][cury]))) {
                                map[curx][cury] = '.';
                                queue.add(new int[]{curx, cury});
                            }
                        }
                    }
                }
            }

            if (!foundNewKey) {
                break;
            }

            visited = new boolean[h][w];
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
        bw.close(); br.close();
    }
}