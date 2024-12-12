package LeetCode;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/1457286949/
public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        //This is better because it saves extra itteration
        // if(letters[end] <= target){
        //     return letters[start];
        // }
        while(start <= end){
            int mid = end - (end-start)/2;

            if(letters[mid] <= target){
                start = mid + 1;
            }else if(letters[mid] > target){
                end = mid - 1;
            }
        }
        //Using Modulus 
        return letters[start%letters.length];
    }
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j' };
        char target = 'd';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
