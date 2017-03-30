public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) return digits;
            if (carry == 1) {
                if (digits[i] != 9) {
                    digits[i]++;
                    return digits;
                } else {
                    digits[i] = 0;
                    carry = 1;
                }
            }
        }
        // when result number has higher order(orginal number is all 9)
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            newDigits[i+1] = digits[i];
        }
        return newDigits;
    }
}