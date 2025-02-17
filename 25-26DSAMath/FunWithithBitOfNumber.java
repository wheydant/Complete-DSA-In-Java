public class FunWithithBitOfNumber {
    public static void main(String[] args) {
        int number = 123134453;
        int i = 5;

        System.out.println(findIthBit(number, i));
    }

    public static int findIthBit(int number, int i){
        int mask = 1<<(i-1);

        return number&mask;
    }

    public static int setIthBit(int number, int i){
        int mask = 1<<(i-1);

        return number|mask;
    }

    public static int resetIthBit(int number, int i){
        int mask = 1<<(i-1);
        mask = ~mask;

        return number&mask;
    }

}
