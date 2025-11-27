package KunalKushwaha.Assignments.Recursion;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities{
    int helper(Map<Character, Integer> map){
        boolean noUniqueChar = true;
        for(var mapCh : map.keySet()){
            if(map.get(mapCh) > 0){
                noUniqueChar = false;
                break;
            }
        }
        if(noUniqueChar) return 0;
        //Take each one from
        int countPaths = 0;
        for(char mapCh : map.keySet()){
            if(map.get(mapCh) > 0){
                map.put(mapCh, map.get(mapCh) - 1);
                countPaths = countPaths + 1 + helper(map);
                map.put(mapCh, map.get(mapCh) + 1);
            }
        }
        return countPaths;
    }
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            map.put(tiles.charAt(i), map.getOrDefault(tiles.charAt(i), 0) + 1);
        }
        return helper(map);
    }
    //Can be done efficiently using array
    public int numTilePossibilitiesEfficient(String tiles) {
    int[] count = new int[26];

    for (final char t : tiles.toCharArray())
      ++count[t - 'A'];

    return dfs(count);
  }

  private int dfs(int[] count) {
    int possibleSequences = 0;

    for (int i = 0; i < 26; ++i) {
      if (count[i] == 0)
        continue;
      // Put c in the current position. We only care about the number of possible
      // sequences of letters but don't care about the actual combination.
      --count[i];
      possibleSequences += 1 + dfs(count);
      ++count[i];
    }

    return possibleSequences;
  }
    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("ABC"));//8
    }
}