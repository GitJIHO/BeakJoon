import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int[] visitedTime = new int[cacheSize];
        String[] cache = new String[cacheSize];
        
        int totalTime = 0;
        int curTime = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            curTime++;
            boolean hit = false;
            for (int idx=0; idx<cache.length; idx++) {
                if (city.equals(cache[idx])) {
                    totalTime++;
                    hit = true;
                    visitedTime[idx] = curTime;
                }
            }
            if (!hit) {
                totalTime += 5;
                int oldTime = 100001;
                int oldIdx = -1;
                for (int idx=0; idx<cache.length; idx++) {
                    if (visitedTime[idx] < oldTime) {
                        oldTime = visitedTime[idx];
                        oldIdx = idx;
                    }
                }
                cache[oldIdx] = city;
                visitedTime[oldIdx] = curTime;
           }
        }
        
        return totalTime;
    }
}