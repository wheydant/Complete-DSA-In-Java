public class APowerB {
    public static void main(String[] args) {
        int base = 2;
        int power = 5;

        System.out.println(power(base, power));
        System.out.println(powerByBits(base, power));
    }
    // O(power)
    public static int power(int base, int power){
        int ans = 1;
        for(int i = 0; i < power; i++){
            ans *= base;
        }
        return ans;
    }
    public static int powerByBits(int base, int power){
        int ans = 1;
        while(power > 0){
            if((power&1) == 1){
                ans*=base;
            }
            base *= base;
            power = power >> 1;
        }
        return ans;
    }

}
