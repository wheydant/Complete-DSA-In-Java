package KunalKushwaha.Assignments.Bitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryWatch {
    String bitsToTime(String timeBits){
        int mins = 0;
        int hrs = 0;
        for(int i = 0; i < 6; i++){
            if(timeBits.charAt(i) == '1'){
                mins += Math.pow(2, i);
            }
        }
        for(int i = 6; i < 10; i++){
            if(timeBits.charAt(i) == '1'){
                hrs += Math.pow(2, i - 6);
            }
        }
		if(hrs > 11 || mins >= 60) return "error";
		String time = hrs + ":";
		if(mins < 10) time = time + "0" + mins;
		else time = time + "" + mins;

		return time;
    }
    void allCombinations(List<String> allCombi, int bits, int turnedOn, String timeBits){
        if(bits > 9){
            if(turnedOn == 0){
				String time = bitsToTime(timeBits);
				if(!time.equals("error"))
                	allCombi.add(time);
            }
            return;
        }

        //Include bits
        if(turnedOn > 0){
            allCombinations(allCombi, bits + 1, turnedOn - 1, timeBits + "1");
        }
        //Exclude bits
        allCombinations(allCombi, bits + 1, turnedOn, timeBits + "0");
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> allCombi = new ArrayList<>();
        allCombinations(allCombi, 0, turnedOn, "");
		Collections.sort(allCombi);
		return allCombi;
    }

    public List<String> readBinaryWatchOptimized(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new BinaryWatch().readBinaryWatch(2));
	}
}
