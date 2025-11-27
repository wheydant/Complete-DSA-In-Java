package KunalKushwaha.Assignments.String;

import java.util.*;

public class OptimizedJumpGameVII {
    
    // Method 1: Sliding Window + DP - O(n) Time, O(n) Space
    // Most optimal approach
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        int count = 0; // sliding window count of reachable positions
        
        for (int i = 1; i < n; i++) {
            // Update sliding window for position i
            // Add positions that just came into range
            if (i >= minJump && dp[i - minJump]) {
                count++;
            }
            // Remove positions that are now out of range
            if (i > maxJump && dp[i - maxJump - 1]) {
                count--;
            }
            
            // Current position is reachable if:
            // 1. It's a '0' (not blocked)
            // 2. There's at least one reachable position in valid jump range
            dp[i] = s.charAt(i) == '0' && count > 0;
        }
        
        return dp[n - 1];
    }
    
    // Method 2: BFS Approach - O(n) Time, O(n) Space
    // Good for understanding the problem visually
    public boolean canReachBFS(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int furthest = 0; // optimization to avoid checking same positions
        
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            
            // Check all valid jump positions from current position
            int start = Math.max(pos + minJump, furthest + 1);
            int end = Math.min(pos + maxJump, n - 1);
            
            for (int next = start; next <= end; next++) {
                if (s.charAt(next) == '0' && !visited[next]) {
                    if (next == n - 1) return true; // reached the end
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            furthest = Math.max(furthest, pos + maxJump);
        }
        
        return false;
    }
    
    // Method 3: Your Original Logic (Fixed) - O(n × maxJump) 
    // For comparison - less optimal but easier to understand
    public boolean canReachOriginal(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        
        boolean[] reachable = new boolean[n];
        reachable[0] = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') continue;
            boolean flag = false;

            for (int j = minJump; j <= maxJump && i - j >= 0; j++) {
                if (reachable[i - j]) {
                    flag = true;
                    break;
                }
            }
            reachable[i] = flag;
        }

        return reachable[n - 1];
    }
    
    // Method 4: Greedy Approach - O(n) Time, O(1) Space
    // Most space efficient
    public boolean canReachGreedy(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        
        int maxReach = 0; // furthest position we can reach
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && (i == 0 || i <= maxReach)) {
                // Update the furthest we can reach from this position
                maxReach = Math.max(maxReach, i + maxJump);
                
                // If we can reach the end, return true
                if (maxReach >= n - 1) return true;
            }
        }
        
        // Check if we can actually jump to the last position
        return maxReach >= n - 1 && s.charAt(n - 1) == '0';
    }

    // Performance testing method
    public static void testPerformance() {
        OptimizedJumpGameVII solution = new OptimizedJumpGameVII();
        
        // Large test case
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i % 3 == 0 ? '0' : '1'); // pattern with some 0s
        }
        String largeTest = sb.toString();
        largeTest = "0" + largeTest.substring(1, largeTest.length() - 1) + "0";
        
        System.out.println("Testing performance on large input (100k characters):");
        
        long start = System.nanoTime();
        boolean result1 = solution.canReach(largeTest, 100, 200);
        long time1 = System.nanoTime() - start;
        System.out.println("Sliding Window DP: " + result1 + " - Time: " + time1/1_000_000 + "ms");
        
        start = System.nanoTime();
        boolean result2 = solution.canReachBFS(largeTest, 100, 200);
        long time2 = System.nanoTime() - start;
        System.out.println("BFS Approach: " + result2 + " - Time: " + time2/1_000_000 + "ms");
        
        start = System.nanoTime();
        boolean result3 = solution.canReachGreedy(largeTest, 100, 200);
        long time3 = System.nanoTime() - start;
        System.out.println("Greedy Approach: " + result3 + " - Time: " + time3/1_000_000 + "ms");
    }

    public static void main(String[] args) {
        OptimizedJumpGameVII q = new OptimizedJumpGameVII();
        
        // Test cases
        System.out.println("=== Test Cases ===");
        System.out.println(q.canReach("0000000000", 2, 5)); // true
        System.out.println(q.canReach("011010", 2, 3));     // false
        System.out.println(q.canReach("010000", 3, 3));     // true
        
        System.out.println("\n=== BFS Results ===");
        System.out.println(q.canReachBFS("0000000000", 2, 5)); // true
        System.out.println(q.canReachBFS("011010", 2, 3));     // false
        System.out.println(q.canReachBFS("010000", 3, 3));     // true
        
        System.out.println("\n=== Greedy Results ===");
        System.out.println(q.canReachGreedy("0000000000", 2, 5)); // true
        System.out.println(q.canReachGreedy("011010", 2, 3));     // false
        System.out.println(q.canReachGreedy("010000", 3, 3));     // true
        
        // Uncomment to test performance
        // testPerformance();
    }
}