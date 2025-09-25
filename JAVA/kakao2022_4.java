import java.util.*;

class Solution {
    int maxDiff = -1;
    int[] bestCase;

    public int[] solution(int n, int[] info) {
        bestCase = new int[]{-1};
        dfs(0, n, new int[11], info);
        return bestCase;
    }

    private void dfs(int idx, int arrows, int[] lion, int[] apeach) {
        if (idx == 11 || arrows == 0) {
            if (arrows > 0) lion[10] += arrows;

            int diff = calcDiff(lion, apeach);
            if (diff > maxDiff) {
                maxDiff = diff;
                bestCase = lion.clone();
            } else if (diff == maxDiff && diff > 0) {
                if (isBetter(lion, bestCase)) {
                    bestCase = lion.clone();
                }
            }

            if (arrows > 0) lion[10] -= arrows;
            return;
        }

        if (arrows > apeach[idx]) {
            lion[idx] = apeach[idx] + 1;
            dfs(idx + 1, arrows - (apeach[idx] + 1), lion, apeach);
            lion[idx] = 0;
        }

        dfs(idx + 1, arrows, lion, apeach);
    }

    private int calcDiff(int[] lion, int[] apeach) {
        int l = 0, a = 0;
        for (int i = 0; i <= 10; i++) {
            if (lion[i] == 0 && apeach[i] == 0) continue;
            if (lion[i] > apeach[i]) l += (10 - i);
            else a += (10 - i);
        }
        return (l > a) ? (l - a) : -1;
    }

    private boolean isBetter(int[] lion, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > best[i]) return true;
            else if (lion[i] < best[i]) return false;
        }
        return false;
    }
}
