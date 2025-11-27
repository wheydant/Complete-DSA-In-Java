package KunalKushwaha.Assignments.Recursion;

public class LengthOfString{
    static int recLen(String str){
        if(str.length() == 0) return 0;
        return 1 + recLen(str.substring(1, str.length()));
    }
    public static void main(String[] args)
    {
        String str = "GeeksforGeeks";
        System.out.println(recLen(str));
    }
}