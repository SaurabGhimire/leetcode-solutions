package neetcode150.mathAndGeometry;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n>=1){
            if(set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            while(n>0){
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            if(sum == 1) return true;
            n = sum;
        }
        return false;
    }
}
