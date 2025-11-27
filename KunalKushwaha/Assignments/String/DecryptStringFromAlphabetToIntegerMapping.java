package KunalKushwaha.Assignments.String;

public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0 ; i--){
            String strNo;
            int number;
            if(s.charAt(i) == '#'){
                strNo = s.substring(i - 2, i);
                // System.out.println(strNo);
                i = i - 2;
            }else{
                strNo = s.charAt(i) + "";
            }
            number = Integer.parseInt(strNo);
            sb.append((char)(96 + number));
        }

        // return sb.toString();
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets("10#11#12")); // "jkab"

        System.out.println(new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets("1326#")); // "acz"
    }
}
