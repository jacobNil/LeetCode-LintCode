// april 22: time limit exceeded

public class Solution {
    public boolean canIWin(int max, int target) {
        if(((max + 1) * max /2) < target) {
            return false;
        }
        if(target <= max) {
            return true;
        }

        return dfsHelper(max, target, 0, 0, new HashMap<Integer, Boolean>());
    }
    
    private boolean dfsHelper(int max, int target, int current, int used, HashMap<Integer, Boolean> memory ) {
        // read memory first---> memorized search
        if(current >= target) return false;
        
        if(memory.containsKey(used)) {
            return memory.get(used);
        }
        // if this condition has never been calculated
        for(int i = 1; i < max+1; i++) {
            // if the number i has been used---> skip this iteration
            if((used &= (1<<i)) != 0) {
                continue;
            }
            int nextUsed = used | (1<<i);
            // base case
            
            if (!dfsHelper(max, target, current+i, nextUsed, memory)) {
                memory.put(used, true);
                return true;
            }
            
            
        }
        memory.put(used, false);
        return false;
    }
}


// solution from bittiger 萌萌
public class Solution {
    public boolean canIWin(int max, int total) {
        if(total <= 0) return true;
        if(((max*max + max)/2) < total) return false;
        
        return helper(total, max, 0, new HashMap<Integer, Boolean>());
    }
    
    private boolean helper(int total, int max, int state, HashMap<Integer, Boolean> cache) {
        // base case
        if(total < 0) return true;
        // read cache
        if(cache.containsKey(state)) return cache.get(state);
        // try each possible number
        for(int i = 0; i < max; i++) {
            // if the number has been used
            if((state &= (1<<i)) != 0) {
                continue;
            }
            // induction rules
            if(!helper(total-i-1, max, state|(1<<i), cache)) {
                cache.put(state, true);
                return true;
            }
        }
        cache.put(state, false);
        return false;
        
    }
}