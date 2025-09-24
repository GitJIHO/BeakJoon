import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;
        
        for (int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if (Character.isDigit(c)) {
                int num;
                if (c == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    num = 10;
                    i++;
                } else {
                    num = c - '0';
                }
                
                i++;
                char bouns = dartResult.charAt(i);
                int power = 1;
                if (bouns == 'S') power = 1;
                else if (bouns == 'D') power = 2;
                else if (bouns == 'T') power = 3;
                
                idx++;
                scores[idx] = (int) Math.pow(num, power);
                
                if (i + 1 < dartResult.length()) {
                    char op = dartResult.charAt(i + 1);
                    if (op == '*') {
                        scores[idx] *= 2;
                        if (idx - 1 >= 0) scores[idx - 1] *= 2;
                    } else if (op == '#') {
                        scores[idx] *= -1;
                        i++;
                    }
                }
                
            }
        }
        
        return scores[0] + scores[1] + scores[2];
    }
}