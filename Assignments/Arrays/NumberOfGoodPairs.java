public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    goodPairs++;
                }
            }
        }
        return goodPairs;
    }
    public static int numIdenticalPairsOptimum(int[] nums) {
        int goodPairs = 0;
        //As 100 is the max value thus counting how many times number has encountered
        int[] count = new int[101];
        for (int a: nums) {
            //As we add first than add it thus for first encounter it is not registered
            goodPairs += count[a]++;
        }
        return goodPairs;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(numIdenticalPairs(nums));
        System.out.println(numIdenticalPairsOptimum(nums));
    }
}
