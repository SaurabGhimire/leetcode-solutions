package neetcode150.bitManipulation;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = (n & 1);
            res <<= 1;
            res = res | bit;
            n >>= 1;
        }
        return res;
    }
}