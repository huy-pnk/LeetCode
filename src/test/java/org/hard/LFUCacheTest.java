package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LFUCacheTest {

    /**
     * ["LFUCache","put","put","put","put","get"]
     * [[2],[3,1],[2,1],[2,2],[4,4],[2]]
     * Expected: [null,null,null,null,null,2]
     */
    @Test
    public void putOnExistingKeyUpdatesInsteadOfEvicting() {
        LFUCache cache = new LFUCache(2);
        cache.put(3, 1);   // {3:1}                     freq 3 = 1
        cache.put(2, 1);   // {3:1, 2:1}                freq 2 = 1
        cache.put(2, 2);   // key 2 already present -> update value, freq 2 = 2
        cache.put(4, 4);   // full: evict key 3 (freq 1), keep key 2 (freq 2)
        Assertions.assertEquals(2, cache.get(2));
    }

    /**
     * ["LFUCache","put","put","get","get","put","get","get","get"]
     * [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
     * Expected: [null,null,null,2,1,null,1,-1,3]
     */
    @Test
    public void breaksFrequencyTieByLeastRecentlyUsed() {
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);                          // {2:1}          freq 2 = 1
        cache.put(3, 2);                          // {2:1, 3:2}     freq 3 = 1
        Assertions.assertEquals(2, cache.get(3)); // freq 3 = 2
        Assertions.assertEquals(1, cache.get(2)); // freq 2 = 2
        cache.put(4, 3);                          // tie at freq 2 -> evict key 3 (used least recently)
        Assertions.assertEquals(1, cache.get(2));
        Assertions.assertEquals(-1, cache.get(3));
        Assertions.assertEquals(3, cache.get(4));
    }
}
