package KunalKushwaha.Assignments.Searching;

public class FirstBadVersion {
    static boolean isBadVersion(int version){
        return version >= 2;
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(6));
    }
}
