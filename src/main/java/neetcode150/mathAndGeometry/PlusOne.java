package neetcode150.mathAndGeometry;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int carry = 0;
        for(int i=digits.length-1;i>=0;i--){
            int digit = digits[i];
            if(carry == 1 || i==digits.length-1){
                res[i] = digit == 9? 0: digit+1;
                carry = digit == 9 ? 1:0;
            } else{
                res[i] = digit;
                carry = 0;
            }
        }
        if(carry == 0) return res;
        int[] resWithCarry = new int[digits.length+1];
        resWithCarry[0] = 1;
        System.arraycopy(res, 0, resWithCarry, 1, digits.length);
        return resWithCarry;
    }
}