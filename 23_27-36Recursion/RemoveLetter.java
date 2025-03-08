

public class RemoveLetter {
    public static void main(String[] args) {
        String str = "baccad";
        String ans = "";
        // removeA(str, ans);
        System.out.println(removeA(str));
        // removeA(str, 0, ans);
        // System.out.println(ans);

        str = "appleabapplebappb";
        System.out.println(skipAppNotApple(str));

        //Str remains the og only no changes to string has occured before passing to below fn call
        System.out.println(skipApple(str));
    }
    //Two methods ans in arguement, ans variable in function body.

    //This doesn't work as in java String are immutable and every time new string is created.
    // static void removeA(String str, int start, String ans){
    //     if(start == ans.length()){
    //         return;
    //     }
    //     if(str.charAt(start) != 'a'){
    //         ans += str.charAt(start);
    //     }
    //     removeA(str, start + 1, ans);
    // }

    //Each time we need to pass and deal with new String.
    static void removeA(String str, String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            removeA(str.substring(1), ans);
        }else{
            removeA(str.substring(1), ans + ch);
        }
    }

    //Returning a String
    static String removeA(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            return removeA(str.substring(1));
        }else{
            return ch + removeA(str.substring(1));
        }
    }

    static String skipApple(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }else{
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    static String skipAppNotApple(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("app") && !str.startsWith("apple")){
            return skipAppNotApple(str.substring(3));
        }else{
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }
}
