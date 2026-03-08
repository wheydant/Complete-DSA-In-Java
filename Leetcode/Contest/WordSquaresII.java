package Leetcode.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordSquaresII {
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> squares = new ArrayList<>();
		Arrays.sort(words);
		HashMap<Character, List<String>> map = new HashMap<>();

		for(int i = 0; i < words.length; i++){
			List<String> currWords = map.getOrDefault(words[i].charAt(0), new ArrayList<>());
			currWords.add(words[i]);
			map.put(words[i].charAt(0), currWords);
		}
		String top;
		String left;
		String bottom;
		String right;
		for(int i = 0; i < words.length; i++){
			List<String> currSquare = new ArrayList<>();
			top = words[i];
			List<String> topHead = map.get(top.charAt(0));
			currSquare.add(top);
			for(int j = 0 ; j < topHead.size(); j++){
				if(currSquare.size() > 1) currSquare.
				if(!currSquare.contains(topHead.get(j))){
					left = topHead.get(j);

					List<String> leftTail = map.getOrDefault(left.charAt(3), new ArrayList<>());
					for(int k = 0; k < leftTail.size(); k++){
						if(!vis.containsKey(leftTail.get(k))){
							bottom = leftTail.get(k);
							vis.put(bottom, true);
							List<String> topTail = map.getOrDefault(top.charAt(3), new ArrayList<>());
							for(int l = 0; l < topTail.size(); l++){
								if(!vis.containsKey(topTail.get(l))){
									if(topTail.get(l).charAt(3) == bottom.charAt(3)){
										right = topTail.get(l);
										squares.add(Arrays.asList(top, left, right, bottom));
									}
								}
							}
						}
					}
				}
			}
		}
		return squares;
	}

    Map<String, List<String>> prefixMap = new HashMap<>();
    int len;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words.length == 0) return result;

        len = words[0].length();

        // Build prefix map
        for (String word : words) {
            for (int i = 0; i <= len; i++) {
                String prefix = word.substring(0, i);
                prefixMap.computeIfAbsent(prefix, k -> new ArrayList<>()).add(word);
            }
        }

        // Backtracking
        for (String word : words) {
            List<String> square = new ArrayList<>();
            square.add(word);
            backtrack(square, result);
        }
        return result;
    }

    private void backtrack(List<String> square, List<List<String>> result) {
        if (square.size() == len) {
            result.add(new ArrayList<>(square));
            return;
        }

        int idx = square.size();
        StringBuilder prefix = new StringBuilder();
        for (String s : square) {
            prefix.append(s.charAt(idx));
        }

        for (String candidate : prefixMap.getOrDefault(prefix.toString(), new ArrayList<>())) {
            square.add(candidate);
            backtrack(square, result);
            square.remove(square.size() - 1);
        }
    }

	public static void main(String[] args) {
		System.out.println(new WordSquaresII().wordSquares(new String[] { "able", "area", "echo", "also" }));
	}
}
