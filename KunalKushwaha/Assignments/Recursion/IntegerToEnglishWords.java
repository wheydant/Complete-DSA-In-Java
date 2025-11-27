package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToEnglishWords {
	public String numberToWords(int num) {
		int digits = (int)Math.log10(num) + 1;
		String[] unitDigits = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		String[] tensDigits = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String[] tensOne = {"Ten", "Eleven", "Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] denominations = {"","Thousand", "Million", "Billion"};

		List<String> numberToWords = new ArrayList<>();
		int prevDigit = 0;
		int denomination = 0;

		for(int i = 0; i < digits; i++){
			int digit = num%10;
			// System.out.println("i%3 = " + i%3);
			if(i%3 == 1){
				//Ty but handle 1 case
				if(digit == 1){
					numberToWords.remove(numberToWords.size() - 1);
					numberToWords.add(tensOne[prevDigit]);
				}else{
					numberToWords.add(tensDigits[digit]);
				}
			}else if(i%3 == 2){
				//hundred + normal
				numberToWords.add("Hundred");
				numberToWords.add(unitDigits[digit]);
			}else{
				//denomination + normal
				numberToWords.add(denominations[denomination++]);
				numberToWords.add(unitDigits[digit]);
			}
			prevDigit = digit;
			num /= 10;
			// System.out.println(numberToWords.toString());
		}
		Collections.reverse(numberToWords);
		numberToWords.remove(numberToWords.size() - 1);
		String numberToWord = String.join(" ", numberToWords);
		return numberToWord;
	}
	public String numberToWordsClaude(int num) {
		if(num == 0) return "Zero";
		
		int digits = (int)Math.log10(num) + 1;
		String[] unitDigits = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		String[] tensDigits = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String[] tensOne = {"Ten", "Eleven", "Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] denominations = {"","Thousand", "Million", "Billion"};

		List<String> numberToWords = new ArrayList<>();
		int prevDigit = 0;
		int denomination = 0;

		for(int i = 0; i < digits; i++){
			int digit = num%10;
			
			if(i%3 == 1){
				//Ty but handle 1 case
				if(digit == 1){
					numberToWords.remove(numberToWords.size() - 1);
					numberToWords.add(tensOne[prevDigit]);
				}else if(digit > 1){ // FIX: Changed to > 1 instead of != 0
					numberToWords.add(tensDigits[digit]);
				}
				// If digit == 0, don't add anything (handles cases like 100, 1000, etc.)
			}else if(i%3 == 2){
				//hundred + normal
				if(digit != 0){
					numberToWords.add("Hundred");
					numberToWords.add(unitDigits[digit]);
				}
			}else{
				//denomination + normal
				if(i > 0 && (num%1000) != 0){
					numberToWords.add(denominations[denomination]);
				}
				denomination++;
				if(digit != 0){
					numberToWords.add(unitDigits[digit]);
				}
			}
			prevDigit = digit;
			num /= 10;
		}
		Collections.reverse(numberToWords);
        String numberToWord = numberToWords.stream()
                                   .filter(s -> s != null && !s.isEmpty())
                                   .collect(Collectors.joining(" "));
        String result = numberToWord.trim();
		return result;
	}

	class Solution {
		public String numberToWords(int num) {
			if(num == 0)
				return "Zero";
			String[] bigString = {"Thousand","Million","Billion"};
			String result = numberToWordsHelper(num%1000);
			num = num/1000;
			if(num > 0 && num%1000>0){
				result = numberToWordsHelper(num%1000) + "Thousand " + result;
			}
			num = num/1000;
			if(num > 0 && num%1000>0){
				result = numberToWordsHelper(num%1000) + "Million " + result;
			}
			num = num/1000;
			if(num > 0){
				result = numberToWordsHelper(num%1000) + "Billion " + result;
			}
			return result.trim();
		}

		public String numberToWordsHelper(int num){
			String[] digitString = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
			String[] teenString = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
			String[] tenString = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
			String result = "";
			if(num > 99){
				result += digitString[num/100] + " Hundred ";
			}
			num = num % 100;
			if(num < 20 && num > 9){
				result += teenString[num%10]+" ";
			}else{
				if(num > 19){
					result += tenString[num/10]+" ";
				}
				num = num % 10;
				if(num > 0)
					result += digitString[num]+" ";
			}
			return result;
		}
	}
	public static void main(String[] args) {
		System.out.println(new IntegerToEnglishWords().numberToWordsClaude(1234567));//"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		System.out.println(new IntegerToEnglishWords().numberToWordsClaude(2147483647));//"two billion one hundred forty-seven million four hundred eighty-three thousand six hundred forty-seven"
		System.out.println("Claude");
		System.out.println(new IntegerToEnglishWords().numberToWordsClaude(1000)); // "One Thousand"
		System.out.println(new IntegerToEnglishWords().numberToWordsClaude(1234567)); // "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		System.out.println(new IntegerToEnglishWords().numberToWordsClaude(2147483647)); // "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven"
		System.out.println(new IntegerToEnglishWords().numberToWordsClaude(10)); // "Zero"
	}
}
