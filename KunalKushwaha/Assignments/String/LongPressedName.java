package KunalKushwaha.Assignments.String;
public class LongPressedName{
    public boolean isLongPressedNameMySolution(String name, String typed) {
        int n = name.length();
        int m = typed.length();

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(name.charAt(i) != typed.charAt(j)){
                if(j > 0){
                    if(name.charAt(i) != typed.charAt(j - 1)) return false;
                    i++;
                    continue;
                }else return false;
            }

            while(j < m && typed.charAt(j) == name.charAt(i)) j++;
            i++;
        }

        return j == m;
    }

    public boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0)!=typed.charAt(0)){
            return false;
        }
        int n = name.length();
        int m = typed.length();
        if(n > m){
            return false;
        }
        int i=1;
        int j=1;
        while(j < m){
            if(i < n && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if (typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }
            else{
                return false;
            }
        }
        return i == n;
    }
    public static void main(String[] args) {
        // System.out.println(new LongPressedName().isLongPressedName("alex", "aaleex"));

        // System.out.println(new LongPressedName().isLongPressedName("saeed", "ssaaedd"));

        System.out.println(new LongPressedName().isLongPressedName("leelee", "lleeelee"));
    }
    
}