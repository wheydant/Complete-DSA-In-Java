import java.util.Scanner;

class example1{
    static String checkDiv(int num){
        boolean flagEven = false;
        boolean flagOdd = false;

        for (int i = 2; i <= num; i++){
            if(num%2==0 || num%i == 0)
                flagEven = true;
            i++;
            if(num%2!=0 || num%i == 0)
                flagOdd = true;
            if(flagEven && flagOdd)
                break;
        }

        if(flagEven && flagOdd)
            return "Both";
        if(flagEven)
            return "Even";
        if(flagOdd)
            return "Odd";
        return "0/1 is not even nor odd";
            
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        // System.out.println(x);
        System.out.println(checkDiv(num));
        sc.close();
    }
}