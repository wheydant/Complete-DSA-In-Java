import java.util.Scanner;

public class fibo {
    // 1, 1, 2, 3, 5, 8, 13, 21
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        // int k = 2;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number :");
            int val = sc.nextInt();
            System.out.println("Fibonacci Series is :");

            for (int num = 0; num < val; num++) {
                System.out.println(i);
                int temp = i + j;
                i = j;
                j = temp;
            }
        }
    }
}
