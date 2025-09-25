import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] mailCount = new int[id_list.length];
        
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            idxMap.put(id_list[i], i);
        }
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        
        for (String repo : report) {
            String[] re = repo.split(" ");
            String reporter = re[0];
            String target = re[1];
            
            if (reportMap.get(reporter).add(target)) {
                if (countMap.get(target) == null) {
                    countMap.put(target, 1);
                } else {
                    countMap.put(target, countMap.get(target) + 1);
                }
            }
        }
        
        Set<String> banned = new HashSet<>();
        for (String user : countMap.keySet()) {
            if (countMap.get(user) >= k) {
                banned.add(user);
            }
        }
        
        for (String reporter : reportMap.keySet()) {
            for (String target : reportMap.get(reporter)) {
                if (banned.contains(target)) {
                    mailCount[idxMap.get(reporter)]++;  
                }
            }
        }
        
        return mailCount;
    }
}