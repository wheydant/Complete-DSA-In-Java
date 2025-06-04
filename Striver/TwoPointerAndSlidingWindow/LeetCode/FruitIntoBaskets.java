package Striver.TwoPointerAndSlidingWindow.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class FruitIntoBaskets {
    //Can be done using set
    public static int totalFruit(int[] fruits) {
        int maxTree = 0;
        for(int i = 0; i < fruits.length; i++){
            int tree = 0;
            int[] basket = new int[2];
            Arrays.fill(basket, -1);
            for(int j = i; j < fruits.length; j++){
                if(basket[0] == -1){
                    basket[0] = j;
                    tree++;
                    continue;
                }else if(basket[1] == -1){
                    basket[1] = j;
                    tree++;
                    continue;
                }
                int tree1 = basket[0];
                int tree2 = basket[1];
                if(fruits[j] == tree1 || fruits[j] == tree2){
                    tree++;
                    continue;
                }else{
                    break;
                }
            }

            maxTree = Math.max(maxTree, tree);
        }
        return maxTree;
    }
    //TC - O(2N)
    public static int totalFruitSW(int[] fruits) {
        int maxTree = 0;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxTree = Math.max(maxTree, right - left + 1);
            right++;
        }
        return maxTree;
    }
    //TC = O(n)
    public static int totalFruitSWOptimum(int[] fruits) {
        int maxTree = 0;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            if(map.size() <= 2)
                maxTree = Math.max(maxTree, right - left + 1);
            right++;
        }
        return maxTree;
    }
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
}
