public class PrintNNo {
    public static void main(String[] args) {
        printNoDesc(5);
        System.out.println("------------------");
        printNoAsc(5);
        System.out.println("------------------");
        printNo(5);
    }
    static void printNoDesc(int n){
        if(n == 1){
            System.out.println("1");
            return;
        }
        System.out.println(n);
        printNoDesc(n - 1);
    }
    static void printNoAsc(int n){
        if(n == 0){
            return;
        }
        printNoAsc(n - 1);
        System.out.println(n);
    }
    static void printNo(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printNo(n - 1);
        System.out.println(n);
    }
}
