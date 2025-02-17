public class Factors {
    public static void main(String[] args) {
        factorials(20);
    }
    static void factorials(int n){
        for(int i = 1; i <= Math.sqrt(n); i++){
           if(n%i == 0){
            if(n/i == i){
                System.out.println(i);
            }
            else{
                System.out.println(i);
                System.out.println(n/i);
            }
           }
        }
    }
}
