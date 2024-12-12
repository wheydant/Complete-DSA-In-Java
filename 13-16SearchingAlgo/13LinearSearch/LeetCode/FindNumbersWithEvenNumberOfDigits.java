// Leet Code https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class FindNumbersWithEvenNumberOfDigits {
    //1295
    public static int evenCal(int[] nums){
        int count = 0;
        for(int num : nums){
            boolean flag = true;
            // if(num == 0){
            //     flag = false;
            // }
            while(num != 0){
                num = num/10;
                flag = !flag;
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
    public static int evenStr(int[] nums){
        int count = 0;
        for(int num:nums){
            String strNum = num + "";

            if(strNum.length()%2 == 0)
                count++;
        }
        return count;
    }
    public static int evenLog(int[] nums){
        int count = 0;
        for(int num:nums){
            //Crazy way to calculate Number of digit.
            System.out.println(Math.log10(num));
            if(((int)(Math.log10(num)) + 1) % 2 == 0)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,34,431,1213};
        System.out.println(evenCal(nums));
        System.out.println(evenStr(nums));
        System.out.println(evenLog(nums));
    }
}
