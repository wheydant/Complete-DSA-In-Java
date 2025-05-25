import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger{
    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            result.addFirst(k % 10);
            k /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int k = 806;
        int[] num = {2, 1, 5};
        System.out.println(addToArrayForm(num, k));
    }
}