// 3. Longest Substring Without Repeating Characters

// Given a string s, find the length of the longest 
// substring
//  without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



package Strings;

public class longestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int arr [] = new int[128];
        int len = 0;
        int max = 0;
        int l = 0;

        for(int r=0; r<s.length(); r++){
            int chIdx = s.charAt(r);
            arr[chIdx]++;
            
            if(arr[chIdx] == 2){
                while(s.charAt(l) != s.charAt(r)){
                    int lCharIdx = s.charAt(l);
                    arr[lCharIdx]--;
                    l++;
                }
                arr[s.charAt(l)]--;
                l++;
            }

            if((r-l + 1) > max){
                max = r-l + 1;
            }
        }

        return max;

    }
    
}

