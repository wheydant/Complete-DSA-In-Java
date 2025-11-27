package KunalKushwaha.Assignments.String;

public class SentenceSimilarityIII {

    public boolean areSentencesSimilarMySolution(String sentence1, String sentence2) {
        int s1 = 0;
        int s2 = 0;

        int n1 = sentence1.length();
        int n2 = sentence2.length();

        // Traverse the first part
        while (s1 < n1 && s2 < n2) {
            if (sentence1.charAt(s1) == sentence2.charAt(s2)
                    && (sentence1.charAt(s1) != ' ' || sentence2.charAt(s2) != ' ')) {
                s1++;
                s2++;
            } else {
                break;
            }
        }

        // Two case -
        // 1. One index reached to an end then simply return true.
        if (s1 == n1 || s2 == n2)
            return true;
        // 2. One of the index not ended with ' ' return false e.g. lot lots
        if (sentence1.charAt(s1) != ' ' || sentence2.charAt(s2) != ' ')
            return false;

        s1 = n1 - 1;
        s2 = n2 - 1;
        // Traverse the last part
        while (s1 >= 0 && s2 >= 0) {
            if (sentence1.charAt(s1) == sentence2.charAt(s2)
                    && (sentence1.charAt(s1) != ' ' || sentence2.charAt(s2) != ' ')) {
                s1--;
                s2--;
            } else {
                break;
            }
        }
        if (sentence1.charAt(s1) == ' ' && sentence2.charAt(s2) == ' ')
            return true;

        return false;
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int n1 = words1.length;
        int n2 = words2.length;

        int left = 0; // Common prefix length
        int right1 = n1 - 1, right2 = n2 - 1; // Pointers for suffix matching

        // Find common prefix
        while (left < n1 && left < n2 && words1[left].equals(words2[left])) {
            left++;
        }

        // Find common suffix
        while (right1 >= left && right2 >= left && words1[right1].equals(words2[right2])) {
            right1--;
            right2--;
        }

        // Check if we've matched all words of at least one sentence
        return right1 < left || right2 < left;
    }

    public static void main(String[] args) {
        SentenceSimilarityIII solution = new SentenceSimilarityIII();

        // Test cases
        String[][] testCases = {
                { "My name is Haley", "My Haley" }, // true
                { "eTUny i b R UFKQJ EZx JBJ Q xXz", "eTUny i R EZx JBJ xXz" }, // true
                { "Eating right now", "Eating" }, // true
                { "A", "a A b A" }, // false
                { "A B C D B B", "A B B" }, // false - your failing case
                { "hello world", "hello" }, // true
                { "Luky", "Lucccky" }, // false
                { "A B C D E", "A E" }, // true
                { "A", "A A" } // false
        };

        System.out.println("=== Testing Fixed Solution ===");
        for (String[] test : testCases) {
            String s1 = test[0], s2 = test[1];
            boolean result = solution.areSentencesSimilar(s1, s2);
            System.out.printf("s1: \"%s\"\ns2: \"%s\"\nResult: %b\n\n", s1, s2, result);
        }

        // Detailed trace for the failing case
        System.out.println("=== DETAILED TRACE FOR FAILING CASE ===");
        String failing1 = "eTUny i b R UFKQJ EZx JBJ Q xXz";
        String failing2 = "eTUny i R EZx JBJ xXz";
        System.out.println("s1: \"" + failing1 + "\"");
        System.out.println("s2: \"" + failing2 + "\"");

        solution.areSentencesSimilarWithTrace(failing1, failing2);
    }

    // Helper method to trace the algorithm step by step
    public boolean areSentencesSimilarWithTrace(String sentence1, String sentence2) {
        System.out.println("\n--- TRACING ALGORITHM ---");
        int s1 = 0, s2 = 0;
        int n1 = sentence1.length(), n2 = sentence2.length();

        System.out.println("Phase 1: Prefix matching");
        while (s1 < n1 && s2 < n2 && sentence1.charAt(s1) == sentence2.charAt(s2)) {
            System.out.printf("Match: '%c' at positions s1=%d, s2=%d\n", sentence1.charAt(s1), s1, s2);
            s1++;
            s2++;
        }

        if (s1 == n1)
            return s2 == n2 || sentence2.charAt(s2) == ' ';
        if (s2 == n2)
            return sentence1.charAt(s1) == ' ';
        if (sentence1.charAt(s1) != ' ' && sentence2.charAt(s2) != ' ')
            return false;

        while (s1 < n1 && sentence1.charAt(s1) == ' ')
            s1++;
        while (s2 < n2 && sentence2.charAt(s2) == ' ')
            s2++;
        System.out.printf("After skipping spaces: s1=%d, s2=%d\n", s1, s2);

        System.out.println("\nPhase 2: Suffix matching");
        int e1 = n1 - 1, e2 = n2 - 1;
        while (e1 >= s1 && e2 >= s2 && sentence1.charAt(e1) == sentence2.charAt(e2)) {
            System.out.printf("Match: '%c' at positions e1=%d, e2=%d\n", sentence1.charAt(e1), e1, e2);
            e1--;
            e2--;
        }
        System.out.printf("Final positions: e1=%d, e2=%d, s1=%d, s2=%d\n", e1, e2, s1, s2);

        boolean result = e1 < s1 || e2 < s2;
        System.out.printf("Result: %b (e1 < s1: %b, e2 < s2: %b)\n", result, e1 < s1, e2 < s2);
        return result;
    }
}