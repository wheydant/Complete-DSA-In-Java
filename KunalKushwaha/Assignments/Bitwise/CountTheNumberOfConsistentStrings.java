package KunalKushwaha.Assignments.Bitwise;

public class CountTheNumberOfConsistentStrings {
	public int countConsistentStrings(String allowed, String[] words) {
        int characters = 0;
		for(int i = 0; i < allowed.length(); i++){
			int steps = allowed.charAt(i) - 'a';
			characters |= 1 << steps;
		}
		int count = 0;
		for(String word: words){
			boolean flag = false;
			for(int i = 0; i < word.length(); i++){
				int mask = word.charAt(i) - 'a';
				if((characters & 1 << mask) == 0){
					flag = true;
					break;
				}
			}
			if(flag) continue;
			count++;
		}
		return count;
		//One line solution
		// return Arrays.stream(words)
        //				.mapToInt(w -> w.chars().allMatch(c -> allowed.contains((char)c + "")) ? 1 : 0)
        //				.sum();
    }
	
	public static void main(String[] args) {
		System.out.println(new CountTheNumberOfConsistentStrings().countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "bc", "bcd"}));
	}
}
