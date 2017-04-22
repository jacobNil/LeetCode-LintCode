//April 22

// mathematical solution. The only accepted by leetcode
public class Solution {
    public boolean canWinNim(int n) {
        return ((n%4) != 0);
    }
}



// dfs recursion
public class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        return (!canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3));
    }
}



// dp version

public class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] canWin = new boolean[n + 1];
        canWin[0] = true;
        canWin[1] = true;
        canWin[2] = true;
        canWin[3] = true;
        for(int i = 4; i < canWin.length; i++) {
            canWin[i] = (!canWin[i-1]||!canWin[i-2]||!canWin[i-3]);
        }
        return canWin[n];
        
    }
}


// dp with rolling array version
public class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] canWin = new boolean[4];
        canWin[0] = flase;
        canWin[1] = true;
        canWin[2] = true;
        canWin[3] = true;
        for(int i = 4; i < canWin.length; i++) {
            canWin[i%4] = (!canWin[(i-1)%4]||!canWin[(i-2)%4]||!canWin[(i-3)%4]);
        }
        return canWin[n%4];
    }
}


