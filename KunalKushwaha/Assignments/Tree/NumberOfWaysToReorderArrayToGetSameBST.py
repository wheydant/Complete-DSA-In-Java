from math import comb


class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        mod = 10**9+7
        def dfs(nums):
            # There is no other way to arrange them as 1, 2; 1 needs to be root always
            if len(nums) <= 2:
                return 1
            left = []
            right = []

            # traverse the arrays except 1st node to find smaller(left) nodes and greater(right) nodes
            for num in nums[1:]:
                if num > nums[0]:
                    right.append(num)
                else:
                    left.append(num)
            
            left_possible = dfs(left)
            right_possible = dfs(right)
            n = len(nums)

            # root arranged(1)* (n - 1)C(left) * left_possible_ways * (n - 1 - len(left))C(right)[1] * right_possible_way
            return ((comb(n - 1, len(left)) * left_possible) * right_possible)%mod

        return (dfs(nums) - 1)%mod