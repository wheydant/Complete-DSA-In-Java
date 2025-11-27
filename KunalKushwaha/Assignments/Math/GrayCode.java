package KunalKushwaha.Assignments.Math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrayCode {
    public List<Integer> grayCodeTLE(int n) {
        Map<String, Boolean> map = new HashMap<>();
		char[] zeroBin = new char[n];
        for(int i = 0; i < n; i++){
            zeroBin[i] = '0';
        }
        map.put(String.valueOf(zeroBin), true);
		List<Integer> codes = new ArrayList<>();
		codes.add(Integer.parseInt(String.valueOf(zeroBin), 2));
        int count = (1 << n);
		count--;
        while(count != 0){
            for(int i = zeroBin.length - 1; i >= 0; i--){
				if(zeroBin[i] == '0'){
					zeroBin[i] = '1';
					if(map.containsKey(String.valueOf(zeroBin))){
						zeroBin[i] = '0';
					}else{
						count--;
						map.put(String.valueOf(zeroBin), true);
						codes.add(Integer.parseInt(String.valueOf(zeroBin), 2));
					}
				}else{
					zeroBin[i] = '0';
					if(map.containsKey(String.valueOf(zeroBin))){
						zeroBin[i] = '1';
					}else{
						count--;
						map.put(String.valueOf(zeroBin), true);
						codes.add(Integer.parseInt(String.valueOf(zeroBin), 2));
					}
				}
			}
        }
		return codes;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        n = (1 << n);
        for (int i = 0; i < n; i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }

	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(2));
	}
}
