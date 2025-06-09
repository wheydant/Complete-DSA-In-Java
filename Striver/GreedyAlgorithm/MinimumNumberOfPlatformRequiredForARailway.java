package Striver.GreedyAlgorithm;

import java.util.Arrays;

public class MinimumNumberOfPlatformRequiredForARailway {
    //TC - O(n^2)
    static int numberOfPlatformBruteForce(int[] arrival, int[] departure){
        int maxPlatform = 0;
        for(int i = 0; i < arrival.length; i++){
            int arrivalTime = arrival[i];
            int departureTime = departure[i];
            int platform = 1;
            for(int j = i + 1; j < arrival.length; j++){
                if((arrival[j] < arrivalTime && departure[j] > arrivalTime) || (arrival[j] > arrivalTime && departure[j] < departureTime) || (arrival[j] < departureTime && departure[j] > departureTime) || (arrival[j] < arrivalTime && departure[j] > departureTime)){
                    platform++;
                }
            }
            maxPlatform = Math.max(platform, maxPlatform);
        }

        return maxPlatform;
    }
    static class Pair{
        int time;
        char action;

        public Pair(int time, char action) {
            this.time = time;
            this.action = action;
        }
    }
    //SC - O(2N) TC - O(Nlog(2N))
    static int numberOfPlatform(int[] arrival, int[] departure){
        int n = arrival.length;
        Pair[] time = new Pair[2 * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            time[idx++] = new Pair(arrival[i], 'A');
            time[idx++] = new Pair(departure[i], 'D');
        }

        // Sort by time, with arrival before departure if times are equal
        Arrays.sort(time, (a, b) -> {
            if (a.time == b.time)
                return a.action - b.action; // 'A' < 'D'
            return a.time - b.time;
        });

        int platform = 0;
        int maxPlatform = 0;

        for (Pair p : time) {
            if (p.action == 'A') {
                platform++;
            } else {
                platform--;
            }
            maxPlatform = Math.max(maxPlatform, platform);
        }

        return maxPlatform;
    }
    //TC - O(2n + 2nlogn)
    // But this distorts the original array
    static int numberOfPlatformOptimize(int[] arrival, int[] departure){
        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int maxPlatform = 0;
        int arrivalPtr = 0;
        int departurePtr = 0;
        int platform = 0;
        while(arrivalPtr < n){
            if(arrival[arrivalPtr] < departure[departurePtr]){
                platform++;
                arrivalPtr++;
            }else{
                platform--;
                departurePtr++;
            }
            maxPlatform = Math.max(platform, maxPlatform);
        }
        return maxPlatform;
    }
    public static void main(String[] args) {
        int[] arrival = {900, 945, 955, 1100, 1500, 1800};
        int[] departure = {920, 1200, 1130, 1150, 1900, 2000};

        System.out.println(numberOfPlatformOptimize(arrival, departure));
    }
}
