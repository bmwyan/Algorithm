package week09;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode 146
 * @date Date : 2021年06月06日 23:54
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;


    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity=capacity;

    }

    public int get(int key) {
        return super.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        super.put(key,value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
