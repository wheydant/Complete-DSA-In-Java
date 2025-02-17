public class SqRt {
    public static void main(String[] args) {
        System.out.println(perfectSq(0, 36));
        System.out.printf("%.3f" ,   sqRt(40, 3));
    }
    static int perfectSq(int start, int n){
        int end = n;
        while(start < end){
            int mid = end - (end - start)/2;
            if(mid*mid == n){
                return mid;
            }else if(mid*mid > n){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        return start;
    }
    static double sqRt(int n, int p){
        int s = 0;
        int e = n;

        double root = 0.0;

        while(s <= e){
            int m = s + (e - s)/2;
            if(m*m == n){
                return m;
            }
            if(m*m > n){
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        double incr = 0.1;
        for(int i = 0; i < p; i++){
            while(root*root <= n){
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }

        return root;
    }
}
