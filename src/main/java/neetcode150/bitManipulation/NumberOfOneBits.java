package neetcode150.bitManipulation;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int sum = 0;
        while(n>0){
            int carry = n%2;
            if(carry == 1) sum++;
            n = n/2;
        }
        return sum;
    }
}