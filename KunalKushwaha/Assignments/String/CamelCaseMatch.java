package KunalKushwaha.Assignments.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamelCaseMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> camelMatch = new ArrayList<>();
        String[] patternSplit = pattern.split("(?=[A-Z])");
        boolean lowerCaseFirst = false;
        if(Character.isLowerCase(patternSplit[0].charAt(0))) lowerCaseFirst = true;
        System.out.println(Arrays.toString(patternSplit));
        for(String query:queries){
            String[] UpperCaseSplit = query.split("(?=[A-Z])");
            if(Character.isLowerCase(UpperCaseSplit[0].charAt(0)) && !lowerCaseFirst) UpperCaseSplit = Arrays.copyOfRange(UpperCaseSplit, 1, UpperCaseSplit.length);
            System.out.println(Arrays.toString(UpperCaseSplit));
            if(UpperCaseSplit.length != patternSplit.length){
                camelMatch.add(false);
                continue;
            }
            boolean currCamelMatch = true;
            for(int i = 0; i < patternSplit.length; i++){
                // if(Character.isLowerCase(UpperCaseSplit[i].charAt(0))) continue;
                if(!contains(UpperCaseSplit[i], patternSplit[i])){
                    currCamelMatch = false;
                    break;
                }
            }
            if(currCamelMatch) camelMatch.add(true);
            else camelMatch.add(false);
        }
        return camelMatch;
    }
    boolean contains(String query, String pattern){
        int i = 0;
        int j = 0;
        int n = query.length();
        int m = pattern.length();
        // while(j < m && Character.isLowerCase(pattern.charAt(j)))j++;
        while(i < n && j < m){
            if(query.charAt(i) == pattern.charAt(j)) j++;
            i++;
        }
        return j == m;
    }
    public List<Boolean> camelMatchEasy(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }
        return result;
    }

    private boolean isMatch(String query, String pattern) {
        int i = 0; 

        for (int j = 0; j < query.length(); j++) {
            char qc = query.charAt(j);

            if (i < pattern.length() && qc == pattern.charAt(i)) {
                i++; 
            } else if (Character.isUpperCase(qc)) {
                return false;
            }
        }
        return i == pattern.length();
    }
    public static void main(String[] args) {
        System.out.println(new CamelCaseMatch().camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        System.out.println(new CamelCaseMatch().camelMatch(new String[]{"CompetitiveProgramming","CounterPick","ControlPanel"}, "CooP"));
        System.out.println(new CamelCaseMatch().camelMatch(new String[]{"uAxaqlzahfialcezsLfj","cAqlzyahaslccezssLfj","AqlezahjarflcezshLfj","AqlzofahaplcejuzsLfj","tAqlzahavslcezsLwzfj","AqlzahalcerrzsLpfonj","AqlzahalceaczdsosLfj","eAqlzbxahalcezelsLfj"}, "AqlzahalcezsLfj"));
        System.out.println(new CamelCaseMatch().contains("Control", "Coo"));
    }
}
