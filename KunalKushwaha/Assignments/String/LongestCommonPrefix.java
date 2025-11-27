package KunalKushwaha.Assignments.String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder(strs[0]);

        for(int i = 1; i < strs.length; i++){
            String curr = strs[i];
            int j = 0;
            int k = 0;

            int n = commonPrefix.length();
            int m = curr.length();

            while(j < n && k < m){
                if(commonPrefix.charAt(j) == curr.charAt(k)){
                    j++;
                    k++;
                }else{
                    break;
                }
            }

            commonPrefix.delete(j, n);
        }

        return commonPrefix.toString();
    }
    public String longestCommonPrefixEfficient(String[] strs) {
        if(strs.length==0) return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            //index of checks if substring exists or not and indexOf(prefix) == 0 makes sure its zeros so we keep on removing last element from the prefix till we find a prefix
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
