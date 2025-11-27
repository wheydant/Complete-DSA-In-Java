package KunalKushwaha.Assignments.String;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
            int n = s.length();
        int start = 0;
        int currentCost = 0;
        int maxLength = 0;

        for (int end = 0; end < n; ++end) {
            currentCost += Math.abs(s.charAt(end) - t.charAt(end));

            while (currentCost > maxCost) {
                //Calculate all the values serially
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                ++start;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }



    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd", "axcd", 0)); //2
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("krrgw", "zjxss", 19)); //2

        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd", "cdef", 1)); //0
    }
}
