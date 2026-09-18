package org.medium;

import java.util.*;

public class StoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        int turn = 0; // alice % 2 == 0 , bob % 2 == 1
        int sum = 0;

        List<Integer> linkedListStones = new ArrayList<>();
        Arrays.sort(stones);
        for (int i = 0; i < stones.length; i++) linkedListStones.add(stones[i]);
        while (linkedListStones.size() > 0) {
            for (int i = 0; i < linkedListStones.size(); i++) {
                if((sum + linkedListStones.get(i)) % 3 != 0) {
                    sum += linkedListStones.get(i);
                    linkedListStones.remove(i);
                    break;
                }
                if(i == linkedListStones.size() - 1 && ((sum + linkedListStones.get(i)) % 3 == 0)) {
                    return turn % 2 != 0 ? true : false;
                }
            }
            turn++;
        }

        return sum % 3 != 0? false : true;
    }
}
