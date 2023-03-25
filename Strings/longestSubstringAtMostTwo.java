// 159. Longest Substring with At Most Two Distinct Characters
// Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

// Example 1:

// Input: "eceba"
// Output: 3
// Explanation: t is "ece" which its length is 3.
// Example 2:

// Input: "ccaabbb"
// Output: 5
// Explanation: t is "aabbb" which its length is 5.



package Strings;

public class longestSubstringAtMostTwo {
    public static void main(String args[]){
        System.out.println(longestSubstring(""));
    }

    public static int longestSubstring(String str){
        if(str.length() == 0) return 0;
        int l=0;
        int count =0;
        int max = 0;
        int [] arr = new int[128];

        for(int r=0; r<str.length(); r++){
            if(arr[str.charAt(r)]++ == 0)  count++;   //self written :)

            if(count == 3){
                while(arr[str.charAt(l)] !=1 ){
                    arr[str.charAt(l)]--;
                    l++;
                }
                l++;
                count = 2;
            }

            if(r-l+1 > max){
                max = r-l+1;
            }
            
        }
        return max;

    }
    
}
