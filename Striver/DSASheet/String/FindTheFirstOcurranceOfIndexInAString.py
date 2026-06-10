class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        def tempArr(pattern):
            #last prefix substring
            n = len(pattern)
            lps = [0]*n
            index = 0
            i = 1

            while i < n:
                if pattern[i] == pattern[index]:
                    lps[i] = index + 1
                    index += 1
                    i += 1
                else:
                    if index != 0:
                        index = lps[index - 1]
                    else:
                        lps[i] = 0
                        i += 1
            
            return lps
        
        lps = tempArr(needle)

        i = j = 0

        n = len(haystack)
        m = len(needle)
        while i < n and j < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            else:
                if j != 0:
                    j = lps[j - 1]
                else:
                    i += 1

            if j == m:
                return i - m
        
        return -1
        
        
if __name__ == '__main__':
    print(Solution().strStr("leetcode", "leeto"))