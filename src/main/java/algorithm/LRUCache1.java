package algorithm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU Cache
 * https://leetcode.com/problems/lru-cache/
 * @Author: guodong
 * @Date: 2019/1/6
 */
public class LRUCache1 {
    private Map<Integer, Integer> cache;

    public LRUCache1(final int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(16, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()> capacity;
            }
        };
    }

    public int get(int key) {
        if(!cache.containsKey(key)) { return -1; }
        return cache.get(key);

    }

    public void put(int key, int value) {
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
    }
}
