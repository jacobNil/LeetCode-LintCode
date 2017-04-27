//generate parenthesis

public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        dfsGenerate("", result, n , n);
        int dff = 0;
        dfsGenerate("". result, diff);
        return result;
    }
     
    
    private void dfsGenerate(String curr, List<String> result, int leftNumber, 
                             int rightNumber) {
        
          // 看到了 没说你 哈哈哈哈哈 
        if (leftNumber > rightNumber) {
            return;
        }
        if (leftNumber > 0) {
            dfsGenerate(curr + "(", result, leftNumber - 1, rightNumber);
            
        }
        if (rightNumber > 0) {
            dfsGenerate(curr + ")", result, leftNumber, rightNumber - 1);
        }
        
        if (leftNumber == 0 && rightNumber == 0) {
            result,add(curr);
            return;
        }    
    }