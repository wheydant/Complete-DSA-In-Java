package KunalKushwaha.Assignments.String;

public class MaximumNumberOfRemovalCharachter {
    boolean isSubsequence(String s, String p, boolean[] isRemoved){
        int i = 0;
        int j = 0;

        int n = s.length();
        int m = p.length();

        while(i < n && j < m){
            if(s.charAt(i) == p.charAt(j) && !isRemoved[i]){
                j++;
            }
            i++;
        }

        return j == m;
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = s.length();
        boolean[] isRemoved = new boolean[n];

        int left = 0;
        int right = removable.length;

        int maxRemovals = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            for(int i = 0; i < n; i++) isRemoved[i] = false;
            for(int i = 0; i < mid; i++) isRemoved[removable[i]] = true;

            if(isSubsequence(s, p, isRemoved)){
                maxRemovals = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxRemovals;
    }
    public int maximumRemovalsTLE(String s, String p, int[] removable) {
        int n = s.length();
        boolean[] isRemoved = new boolean[n];

        int count = 0;
        for(int i = 0; i < removable.length; i++){
            isRemoved[removable[i]] = true;
            if(isSubsequence(s, p, isRemoved)) count++;
            else break;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfRemovalCharachter().maximumRemovals("abcacb", "ab", new int[]{3,1,0}));

        System.out.println(new MaximumNumberOfRemovalCharachter().maximumRemovals("abcbddddd", "abcd", new int[]{3,2,1,4,5,6}));


    }
}
