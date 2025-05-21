package neetcode150.mathAndGeometry;

public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        return dfs(x, N);
    }

    public double dfs(double x, long n){
        if(x==0) return 0;
        if(n==0) return 1;
        long dividend = n/2;
        double half = dfs(x, dividend);
        if(n %2 != 0){
            return x * half * half;
        }
        return half * half;
    }
}