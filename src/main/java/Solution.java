import java.util.*;

class Solution {
    static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;

        for (int k = 0; k<n ; k++) {

            while (i < m - 1 && B[i] < A[k])
            { i += 1;}
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public static void main(String[] args){
        int res = solution(new int[]{2,3,4,5},new int[]{5 });
        System.out.println(res);

    }

    public static String longestSubstring(String s) {
        int longestDistance = -1;
        int previousStartIndex = -1 ;
        int previousEndIndex = -1 ;

        int previousDigitIndex = -1;
        int lastCapitalIndex = -1;
        for(int i=0; i< s.length(); i ++){
            Character ch = s.charAt(i);
            if(ch>='A' && ch <='Z') lastCapitalIndex = i;
            if(ch>='0' && ch <= '9' ) {
                if (longestDistance < (i - previousDigitIndex) && lastCapitalIndex >previousDigitIndex && lastCapitalIndex< i){
                    longestDistance = i - previousDigitIndex;
                    previousStartIndex = previousDigitIndex;
                    previousEndIndex = i;
                }
                previousDigitIndex = i;

            }
        }

        if(previousDigitIndex< s.length()-1 && longestDistance< (s.length()- previousDigitIndex) && lastCapitalIndex >previousDigitIndex){
            longestDistance = s.length()-1 - previousDigitIndex;
            previousStartIndex = previousDigitIndex;
            previousEndIndex = s.length();
        }

        if (previousEndIndex == -1) return "";
        return s.substring(previousStartIndex+1, previousEndIndex);

    }

//    public static void main(String[] args){
//        String res = longestSubstring("a0Ba");
//        System.out.println(res);
//    }
}