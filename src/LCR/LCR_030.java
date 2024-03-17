package LCR;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LCR_030 {
}

class RandomizedSet {
    static int[] arr = new int[200000];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int size = -1;
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr[++size] = val;
        map.put(val, size);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.remove(val);
        if (index != size) map.put(arr[size], index);
        arr[index] = arr[size--];
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr[random.nextInt(size + 1)];
    }
}