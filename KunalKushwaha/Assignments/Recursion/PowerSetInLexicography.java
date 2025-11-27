
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetInLexicography {

    // str : Stores input string
    // n : Length of str.
    // curr : Stores current permutation
    // index : Index in current permutation, curr
    static void permuteRec(String str, int n,
                           int index, String curr, List<String> ans)
    {
        // base case
        if (index == n) {
            return;
        }
        ans.add(curr);
        for (int i = index + 1; i < n; i++) {

            curr += str.charAt(i);
            permuteRec(str, n, i, curr, ans);

            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
        return;
    }

    // Generates power set in lexicographic
    // order.
    static List<String> powerSet(String str)
    {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        List<String> ans = new ArrayList<>();
        permuteRec(new String(arr), str.length(), -1, "", ans);
        return ans;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "cab";
        System.out.println(powerSet(str));
    }
}
