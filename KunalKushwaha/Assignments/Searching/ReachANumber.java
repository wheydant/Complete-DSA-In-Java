package KunalKushwaha.Assignments.Searching;

public class ReachANumber {
    public static int reachNumber(int target) {
        /*
        //Greedy Mathematical intuition
        target = Math.abs(target); // We only care about the absolute value
        int sum = 0;
        int steps = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }

        return steps;
         */
        // Optimised approach

        target = Math.abs(target);
        int start = 0, end = target; 
        while (start < end) {
            int mid = start + (end - start) / 2;
            long sum = ((long) mid * (mid + 1)) / 2; 
            if (sum < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int n = end;
        long sum = ((long) n * (n + 1)) / 2;
        
        while ((sum - target) % 2 != 0) {
            n++;
            sum += n;
        }
        
        return n;
    }
    public static void main(String[] args) {
        System.out.println(reachNumber(reachNumber(2)));
    }
}
