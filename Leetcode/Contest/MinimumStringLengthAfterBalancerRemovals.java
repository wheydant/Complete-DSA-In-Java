package Leetcode.Contest;

import java.util.Arrays;

public class MinimumStringLengthAfterBalancerRemovals {
    public int minLengthAfterRemovals(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        int i = 0;
        int j = charArr.length - 1;

		System.out.println(charArr);
        while(i < j){
            if(charArr[i] != charArr[j]){
                i++;
                j--;
            }else{
                break;
            }
        }

        return j - i + 1;
    }
	public static void main(String[] args) {
		System.out.println(new MinimumStringLengthAfterBalancerRemovals().minLengthAfterRemovals("aabbab"));
	}
}
