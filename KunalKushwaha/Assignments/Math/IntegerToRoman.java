package KunalKushwaha.Assignments.Math;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'I');
        map.put(1, 'V');
        map.put(2, 'X');
        map.put(3, 'L');
        map.put(4, 'C');
        map.put(5, 'D');
        map.put(6, 'M');

        int idx = 0;
		StringBuilder roman = new StringBuilder();
        while(num > 0){
            int digit = num%10;
			if(digit < 4){
				for(int i = 0; i < digit; i++){
					roman.insert(0, map.get(idx + 0) + "");
				}
			}else if(digit == 4){
				roman.insert(0, map.get(idx + 1) + "");
				roman.insert(0, map.get(idx + 0) + "");
			}else if(digit == 5){
				roman.insert(0, map.get(idx + 1) + "");
			}else if(digit < 9){
				digit -= 5;
				for(int i = 0; i < digit; i++){
					roman.insert(0, map.get(idx + 0) + "");
				}
				roman.insert(0, map.get(idx + 1) + "");
			}else{
				roman.insert(0, map.get(idx + 2) + "");
				roman.insert(0, map.get(idx + 0) + "");
			}

			num /= 10;
			idx += 2;
        }

		return roman.toString();
    }
	public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(58));
		System.out.println(new IntegerToRoman().intToRoman(3749));
		System.out.println(new IntegerToRoman().intToRoman(1994));
	}
}
