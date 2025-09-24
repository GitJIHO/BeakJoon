import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crew = new int[timetable.length];
        for (int i=0; i<timetable.length; i++) {
            crew[i] = convertToMin(timetable[i]);
        }
        Arrays.sort(crew);
        
        int start = convertToMin("09:00");
        
        int idx = 0;
        int lastTime = 0;
        int busTime = start;
        
        for (int i=0; i<n; i++) {
            int cnt = 0;
            
            while (idx < crew.length && crew[idx] <= busTime && cnt < m) {
                lastTime = crew[idx];
                idx++;
                cnt++;
            }
            
            if (i == n - 1) {
                if (cnt < m) {
                    return convertToTime(busTime);
                } else {
                    return convertToTime(lastTime - 1);
                }
            }
            
            busTime += t;
        }
        return "";
    }
    
    private int convertToMin(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        return hour * 60 + min;
    }
    
    private String convertToTime(int mins) {
        int hour = mins / 60;
        int min = mins % 60;
        return String.format("%02d:%02d", hour, min);
    }
}