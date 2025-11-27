package KunalKushwaha.Assignments.String;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        if (b.equals("")) return 0;

        StringBuilder repeatedA = new StringBuilder(a);
        int repetition = 1;

        // keep appending until repeatedA is at least as long as b
        // same length will create extra repetation which will cover either left or right
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            repetition++;
        }

        // check if b is inside current repeatedA
        if (repeatedA.toString().contains(b)) return repetition;

        // check one more repetition (for overlap case)
        repeatedA.append(a);
        repetition++;
        if (repeatedA.toString().contains(b)) return repetition;

        // not possible
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd", "cbabcdab"));// ab[cdabcdab]cd

        System.out.println(new RepeatedStringMatch().repeatedStringMatch("a", "aa"));// ab[cdabcdab]cd
    }
}
