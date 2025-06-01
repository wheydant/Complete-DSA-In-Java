
import java.util.Scanner;

public class EvenDays {
    public static int evenDays(String month){
        if("Feb".equals(month)){
            return 29/2;
        }
        return 31/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month - ");
        
        String month = sc.nextLine();

        System.out.println(evenDays(month));
    }
}
