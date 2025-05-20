package neetcode150.greedy;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int leftMax = 0;
        int leftMin = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                leftMin++;
                leftMax++;
            } else if(c == ')'){
                leftMin--;
                leftMax--;
            } else{
                leftMin--;
                leftMax++;
            }
            if(leftMax<0) return false;
            if(leftMin<0) leftMin=0;
        }
        return leftMin == 0;
    }
}
