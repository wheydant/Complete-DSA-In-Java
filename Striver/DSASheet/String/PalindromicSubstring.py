class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)

        palindrome_sub = 0
        # Odd palindrome substring
        for i in range(n):
            palindrome_sub += 1
            # Expand from already palindromic window
            left = i - 1
            right = i + 1

            while left >= 0 and right < n and s[left] == s[right]:
                palindrome_sub += 1
                left -= 1
                right += 1
        
        #Even Palindrome Substrings
        for i in range(n - 1):
            left = i
            right = i + 1

            while left >= 0 and right < n and s[left] == s[right]:
                palindrome_sub += 1
                left -= 1
                right += 1
        
        return palindrome_sub
