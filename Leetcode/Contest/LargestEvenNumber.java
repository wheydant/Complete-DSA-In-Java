package Leetcode.Contest;

public class LargestEvenNumber {
	public String largestEven(String s) {
		int indexOfLargest = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '2') {
				indexOfLargest = i + 1;
				break;
			}
		}
		return (indexOfLargest == -1) ? "" : s.substring(0, indexOfLargest);
	}

	public static void main(String[] args) {
		System.out.println(new LargestEvenNumber().largestEven("11121"));
		System.out.println(new LargestEvenNumber().largestEven("221"));
		System.out.println(new LargestEvenNumber().largestEven("1111"));
	}
}
