// uber tage april 29


// solution 1
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        // corner case
        if(n <= 2 || isPrime(n)) {
            return results;
        }
        //get all factors first
        List<Integer> factors = getAllFactors(n);
        //use dfs? to find all factor combination
        dfsHelper(n, 0, factors, results, new ArrayList<Integer>(), new HashSet<String>());
        
        return results;
    }
    
    private void dfsHelper(int n, 
                            int index, 
                            List<Integer> factors, 
                            List<List<Integer>> results, 
                            List<Integer> currResult,
                            Set<String> visited) {
        //corner case
        if(index == factors.size()) {
            if (currResult.size() == 1) {
                return;
            }
            String curr = "";
            for(int i : currResult) {
                curr += i;
            }
            if (visited.contains(curr)) {
                return;
            }
            results.add(currResult);
            visited.add(curr);
            return;
        }
        //recursion case
        // #1 append case
        List<Integer> next1 = new ArrayList<>(currResult);
        next1.add(factors.get(index));
        Collections.sort(next1);
        dfsHelper(n, index+1, factors, results, next1, visited);
        
        // combine case
        for(int i = 0; i < currResult.size(); i++) {
            if(i< currResult.size()-1 && currResult.get(i) == currResult.get(i+1)) {
                continue;
            }
            List<Integer> next2 = new ArrayList<>(currResult);
            int newFactor = next2.get(i) * factors.get(index);
            next2.set(i, newFactor);
            Collections.sort(next2);
            dfsHelper(n, index+1, factors, results, next2, visited);
        }
    }
    
    
    private boolean isPrime(int n) {
        if(n <= 2) {
            return true;
        }
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    // output factors should be sorted
    private List<Integer> getAllFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        int i = 2;
        while (i <= n) {
            if((n%i == 0) && isPrime(i)) {
                factors.add(i);
                n = n/i;
            } else {
                i++;
            }
        }
        return factors;
    }
}




// solution 2

