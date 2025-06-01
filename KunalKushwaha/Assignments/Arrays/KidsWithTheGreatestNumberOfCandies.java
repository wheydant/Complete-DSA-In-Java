import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> isMostCandies = new ArrayList<>(candies.length);
        int mostCandies = 0;
        for(int i = 0; i < candies.length; i++){
            mostCandies = Math.max(mostCandies, candies[i]);
        }

        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= mostCandies){
                isMostCandies.add(true);
            }else{
                isMostCandies.add(false);
            }
        }
        return isMostCandies;
    }
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        System.out.println(kidsWithCandies(candies, 3));
    }
}
