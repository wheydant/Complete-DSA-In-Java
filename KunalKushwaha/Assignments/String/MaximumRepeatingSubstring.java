package KunalKushwaha.Assignments.String;

public class MaximumRepeatingSubstring {
    public int maxRepeatingQuestionMissunderstood(String sequence, String word) {
        int count = 0;
        int i = 1;
        while (!sequence.equals("")) {
            while (sequence.indexOf(word) != 0) {
                sequence = sequence.substring(i, sequence.length());
            }
            if (!sequence.contains(word))
                break;
            count++;
            sequence = sequence.substring(i + word.length() - 1, sequence.length());
        }

        return count;
    }

    public int maxRepeating(String sequence, String word) {
        String tempWord = word;

        int count = 0;

        while (sequence.contains(tempWord)) {
            count++;
            tempWord = tempWord + word;
        }
        return count;
    }

    public int maxRepeatingOptimum(String sequence, String word) {
        int ans = 0; // stores maximum k
        int i = 0;
        char st = word.charAt(0); // first char of 'word'

        while (i < sequence.length()) {
            //Check each subsequence of the word
            if (sequence.charAt(i) == st) { // only check when chars match
                int j = 0, k = 0, l = i; // j = word index, k = count, l = seq index

                // try matching word starting at position i
                while (l < sequence.length() && word.charAt(j) == sequence.charAt(l)) {
                    if (++j == word.length()) { // word fully matched
                        k++; // one full match found
                        j = 0; // reset j to check for next repeat
                    }
                    l++; // move forward in sequence
                }

                ans = Math.max(k, ans); // update maximum k
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(new MaximumRepeatingSubstring().maxRepeating("caababac",
        // "ab"));
        System.out.println(new MaximumRepeatingSubstring().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));

    }
}