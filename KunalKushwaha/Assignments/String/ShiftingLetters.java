package KunalKushwaha.Assignments.String;

public class ShiftingLetters {
    public String shiftingLettersTLE(String s, int[] shifts) {
        char[] sArr = s.toCharArray();
        for(int i = 0; i < shifts.length; i++){
            for(int j = 0; j <= i; j++){
                int shifted = ((sArr[j]-'a') + shifts[i])%26;
                sArr[j] = (char)('a' + shifted);
            }
        }

        // System.out.println(Arrays.toString(sArr));
        return String.valueOf(sArr);
    }

    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] sArr = s.toCharArray();

        long total = 0; // use long to avoid overflow
        // compute suffix sums backwards
        for (int i = n - 1; i >= 0; i--) {
            total = (total + shifts[i]) % 26;
            int shifted = ((sArr[i] - 'a') + (int) total) % 26;
            sArr[i] = (char) ('a' + shifted);
        }

        return String.valueOf(sArr);
    }

    public static void main(String[] args) {
        System.out.println(new ShiftingLetters().shiftingLetters("abc", new int[]{3,5,9}));
    }
}
