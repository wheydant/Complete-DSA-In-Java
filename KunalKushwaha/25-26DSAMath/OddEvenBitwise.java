public class OddEvenBitwise {
    public static void main(String[] args) {
        int number = 5; // Example number

        if (isEvenBitWise(number)) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    public static boolean isEvenBitWise(int number) {
        return (number & 1) == 0;
    }
}