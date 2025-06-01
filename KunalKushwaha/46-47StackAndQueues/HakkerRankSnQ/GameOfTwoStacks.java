import java.util.ArrayList;
import java.util.List;

public class GameOfTwoStacks {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int count = 0;
        int sum = 0;
        return twoStacks(maxSum, a, b, sum, count) - 1;
    }

    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b,int sum, int count){
        if(sum > maxSum){
            return count;
        }
        if(a.size() == 0 || b.size() == 0){
            return count;
        }
        int ans1 = twoStacks(maxSum,a.subList(1, a.size()), b, sum + a.get(0), count + 1);

        int ans2 = twoStacks(maxSum,a, b.subList(1, b.size()), sum + b.get(0), count + 1);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(4);a.add(2);a.add(4);a.add(6);a.add(1);
        b.add(2);b.add(1);b.add(8);b.add(5);

        System.out.println(twoStacks(10, a, b));
    }
}
