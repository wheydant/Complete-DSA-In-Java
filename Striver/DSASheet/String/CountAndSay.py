class Solution:
    def countAndSay(self, n: int) -> str:
        nums = "1"
        self.map = []

        def count(nums):
            self.map = []
            first_char = nums[0]
            cur_freq = 1
            for i in range(1, len(nums)):
                if nums[i] == first_char:
                    cur_freq += 1
                else:
                    self.map.append([int(first_char), cur_freq])
                    first_char = nums[i]
                    cur_freq = 1
            
            self.map.append([int(first_char), cur_freq])
            
            return self.map
            
        def say():
            say = ""
            for num, freq in self.map:
                say = say + str(freq) + str(num)
            
            return say

        for _ in range(n - 1):
            self.map = count(nums)
            print(self.map)
            nums = say()
        
        return nums

if __name__ == '__main__':
    print(Solution().countAndSay(4))