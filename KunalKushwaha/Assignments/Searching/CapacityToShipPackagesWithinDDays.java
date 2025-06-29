package KunalKushwaha.Assignments.Searching;

public class CapacityToShipPackagesWithinDDays{
    boolean isValid(int cap, int[] weights, int days){
        int day = 1;
        int weight = 0;
        for(int i = 0; i < weights.length; i++){
            if(weight + weights[i] > cap){
                day++;
                weight = 0;
            }
            weight += weights[i];
        }

        return day <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }

        int left = maxWeight;
        int right = totalWeight;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(isValid(mid, weights, days)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }
}