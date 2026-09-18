package org.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;

/**
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {
    private Map<Integer, Integer> keyValMap = new HashMap<>();
    private Map<Integer, Integer> freqKeyMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToSetKeys = new HashMap<>();
    private int capacity = 0;
    private int minFreqHolder = 0;
    public LFUCache(int _capacity) {
        capacity = _capacity;
        minFreqHolder = 0;
        keyValMap.clear();
        freqKeyMap.clear();
        freqToSetKeys.clear();
    }

    public void touch(int key) {
        int f = freqKeyMap.get(key);
        LinkedHashSet<Integer> temp = freqToSetKeys.get(f);
        temp.remove(key);
        if(temp.isEmpty()) {
            freqToSetKeys.remove(f);
            if(f == minFreqHolder) minFreqHolder++;
        }
        freqKeyMap.put(key, f+1);
        freqToSetKeys.computeIfAbsent(f+1, k -> new LinkedHashSet<>()).add(key);
    }

    public int get(int key) {
        if(!keyValMap.containsKey(key)) return -1;
        touch(key);
        return keyValMap.get(key);
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyValMap.containsKey(key)) {
            touch(key);
            keyValMap.put(key, value);
            return;
        }

        if(keyValMap.size() == capacity) {
            int evictKey = freqToSetKeys.get(minFreqHolder).iterator().next();
            LinkedHashSet<Integer> temp = freqToSetKeys.get(minFreqHolder);
            temp.remove(evictKey);
            if(temp.isEmpty()) freqToSetKeys.remove(minFreqHolder);
            freqKeyMap.remove(evictKey);
            keyValMap.remove(evictKey);
        }

        keyValMap.put(key, value);
        freqKeyMap.put(key, 1);
        freqToSetKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreqHolder=1;
    }
}
