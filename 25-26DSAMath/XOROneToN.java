public class XOROneToN {
    public static void main(String[] args) {
        int n = 28;
        int a = 3;
        int b = 9;
        System.out.println(XoR(0,n));
        System.out.println(XoRFormula(n));
        System.out.println(XoR(a, b));
        System.out.println(XoRAtoB(a, b));
    }
    public static int XoR(int a, int b){
        int ans = 0;
        for(int i = a; i <= b; i++){
            ans ^= i;
        }
        return ans;
    }
    public static int XoRFormula(int n){
        return switch (n%4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n+1;
            case 3 -> 0;
            default -> -1;
        };
    }
    public static int XoRAtoB(int a, int b){
        return XoRFormula(b) ^ XoRFormula(a - 1);
    }
}
