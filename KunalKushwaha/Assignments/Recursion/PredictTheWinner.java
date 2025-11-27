package KunalKushwaha.Assignments.Recursion;

public class PredictTheWinner{
	int bestOneScore(int i, int j, int[] nums){
		if(i == j) return nums[i];
		if(i > j) return 0;

		int oneScore = Math.max(
			//Take front
			nums[i] + Math.min(
				//Count minimum as second is greedy and will try to give the least value
				bestOneScore(i + 2, j, nums),
				bestOneScore(i + 1, j - 1, nums)
			)
			,
			//Take back
			nums[j] + Math.min(
				bestOneScore(i + 1, j - 1, nums),
				bestOneScore(i, j - 2, nums)
			)
		);

		return oneScore;
	}

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length - 1;
		int bestScoreOne = bestOneScore(0, n, nums);
        int totalScore = 0;
		for(int num: nums) totalScore += num;
		int bestScoreTwo = totalScore - bestScoreOne;
		return bestScoreOne >= bestScoreTwo;
    }

    public static void main(String[] args) {
        System.out.println(new PredictTheWinner().predictTheWinner(new int[]{1,5,2}));      // false
        System.out.println(new PredictTheWinner().predictTheWinner(new int[]{1,5,233,7})); // true
    }
}
