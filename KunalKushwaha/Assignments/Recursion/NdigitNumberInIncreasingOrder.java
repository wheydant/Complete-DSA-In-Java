
import java.util.ArrayList;
import java.util.List;

public class NdigitNumberInIncreasingOrder {
    static boolean isIncreasing(int n){
        int units = n%10;
        n = n/10;
        while(n != 0){
            if(units <= n%10) return false;
            n = n/10;
        }
        return true;
    }
    static void helper(List<Integer> ans, int num, int n){
        if(Math.log10(num) > n) return;
        if(isIncreasing(num)) ans.add(num);
        helper(ans, num + 1, n);
    }
    static List<Integer> nDigitNumber(int n){
        List<Integer> ans = new ArrayList<>();
        int begineerNum = (n != 1)? 1:0;
        for(int i = 1; i < n; i++) begineerNum = begineerNum*10;
        helper(ans, begineerNum, n);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(nDigitNumber(2));
    }
}
