import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = (ruleKey == "type")? 0 : (ruleKey == "color")? 1 : 2;
        int matchCount = 0;
        for(List<String> item : items){
            if(item.get(index) == ruleValue)matchCount++;
        }
        return matchCount;
    }

    public static void main(String[] args) {
        List<List<String>> items = new  ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));
        
        System.out.println(countMatches(items, "type", "phone"));
    }
}
