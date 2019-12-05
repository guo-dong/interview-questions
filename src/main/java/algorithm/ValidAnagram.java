package algorithm;

import java.util.*;

/**
 * 有效字母异位词
 * https://leetcode.com/problems/valid-anagram/
 * @Author: guodong
 * @Date: 2018/11/27
 */
public class ValidAnagram {

    public boolean isAnagramBySort(String s, String t) {

        if(s == null || t == null) return false;
        if(s.length()!=t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc,tc);

    }

    public boolean isAnagramByHash(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length()!=t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for (int c : counter) {
            if(c != 0) return false;
        }
        return true;
    }

    /**
     * Group Anagrams
     * https://leetcode.com/problems/group-anagrams/
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
