package KunalKushwaha.Assignments.Bitwise;

public class SumOfAllSubsetsXORTotal {
    int dfs(int i, int total, int[] nums){
        if(i == nums.length)
            return total;

        return dfs(i + 1, total ^ nums[i], nums) + dfs(i + 1, total, nums);
    }
    public int subsetXORSum(int[] nums) {
        return dfs(0,0,nums);
    }
	public int subsetXORSumOptimum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total |= num;  // Step 1: Compute bitwise OR of all numbers
        }
        return total * (1 << (nums.length - 1));  // Step 2: Multiply by 2^(n-1)
    }
	public static void main(String[] args) {
		System.out.println(new SumOfAllSubsetsXORTotal().subsetXORSum(new int[]{5,1,6,7}));
	}
}
