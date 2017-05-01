// april 26, uber tag
public class Solution {
    public boolean isHappy(int n) {
        if(n < 1) {
            return false;
        }
        if(n == 1) {
            return true;
        }
        Set<Integer> path = new HashSet<>();
        path.add(n);
        while(true) {
            n = nextN(n);
            if(n == 1) {
                return true;
            }
            if(path.contains(n)) {
                return false;
            }
            path.add(n);
        }
        
    }
    private int nextN(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int result = 0;
        while(n > 0) {
            int last = n%10;
            n = n/10;
            result += last * last;
        }
        return result;
    }
}