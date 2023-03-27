// 1456. Maximum Number of Vowels in a Substring of Given Length
// Medium
// 1.1K
// 49
// Companies
// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

// Example 1:

// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.
// Example 2:

// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.
// Example 3:

// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.
 


public class maximumVowelsInSubstring {

    //main function to be written

    public int maxVowels(String s, int k) {
        int count = 0;

        for(int window=0; window<k; window++){
            if(isVowel(s.charAt(window))) count++;
        }
        int left = 0;
        int max = count;

        for(int update= k; update<s.length(); update++){
            if(isVowel(s.charAt(update))) count++;
            if(isVowel(s.charAt(left++))) count--;
            max = Math.max(max, count);
        }
        return max;

    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
    
}
