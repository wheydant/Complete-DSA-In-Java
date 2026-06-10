from math import ceil


class SolutionRabinKarp:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        len_a = len(a)
        len_b = len(b)

        # when len of b makes it difficult to compute
        # max_rep = len_b // len_a + 1
        # But using this we get an extra repeat a = aaac b = aac which will get ignored with single repeat but with aaacaaac we will calculate it no matter what
        """
        min_rep = (len_b + len_a - 1) // len_a
        max_rep = min_rep + 1
        """
        max_rep = ceil(len_b / len_a) + 1

        rep_a = a * max_rep
        
        # print(rep_a)

        len_rep_a = len(rep_a)
        #Rabin Karp - Rolling Hash
        # 26 chars a prime number for better optimization
        p = 29
        mod = 10**9 + 9
        pow_p = [1]*len_rep_a

        # print(p)
        for i in range(1, len_rep_a):
            # Good practice than using **
            pow_p[i] = (pow_p[i - 1]*p) % mod
        
        def value(ch):
            return ord(ch) - ord('a') + 1
        
        hash_b = 0
        hash_a = 0

        for i in range(len_b):
            hash_b = (hash_b + pow_p[i] * value(b[i]) ) % mod
            hash_a = (hash_a + pow_p[i] * value(rep_a[i]) ) % mod
        
        # print(hash_b)
        # print(hash_a)

        # Rolling Hash
        left = 0
        right = len_b

        while right < len_rep_a:
            # b has c*1 + c*29 + .... but after rolling we have a*p[left]
            # It works for left == 0 because its 1
            target_hash = (hash_b * pow_p[left])%mod

            if hash_a == target_hash:
                # Safe to check as Rabin-Karp can have collision
                if rep_a[left:right] == b:
                    return (right + len_a - 1) // len_a

            hash_a = (hash_a - pow_p[left] * value(rep_a[left]) ) % mod
            hash_a = (hash_a + pow_p[right]* value(rep_a[right]) ) % mod
            
            left += 1
            right += 1
        
        return -1

class SolutionZFunc:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        len_a = len(a)
        len_b = len(b)

        max_rep = ceil(len_b/len_a) + 1

        s = b + '$' + a * max_rep
        
        # print(s)
        len_s = len(s)
        z = [0] * len_s

        l = r = 0
        for k in range(1, len_s):
            if k > r:
                l = r = k

                while r < len_s and s[r] == s[r - l]:
                    r += 1
                
                z[k] = r - l
                r -= 1
            
            else:
                # Inside box
                k_copy = k - l
                # Value doesn't exceed box boundary copy it
                if z[k_copy] < r - k + 1:
                    z[k] = z[k_copy]
                # Shrink box from left and try expanding box to right
                else:
                    l = k
                    while r < len_s and s[r] == s[r - l]:
                        r += 1
                    z[k] = r - l
                    r -= 1
            
            if z[k] == len_b:
                # return ceil((k - len_b - 1  + len_b)/len_a)
                return ceil((k - 1)/len_a)

        return -1

if __name__ == '__main__':
    print(SolutionZFunc().repeatedStringMatch('abcd', 'cdabcdab'))