class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        lps = [0]*n

        index = 0
        i = 1

        while i < n:
            if s[index] == s[i]:
                lps[i] += index + 1
                index += 1
                i += 1
            else:
                if index > 0:
                    index = lps[index - 1]
                else:
                    i += 1
        
        return s[:lps[-1]]
    
if __name__ == '__main__':
    print(Solution().longestPrefix('level'))