public class PrimeNo {
    public static void main(String[] args) {
        System.out.println(isPrime(7));
        primeTillN(30);
    }
    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        int c = 2;
        while(c*c <= n){
            if(n%c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
    static void primeTillN(int n){
        for(int i = 1; i <= n; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
        System.out.println("Using Sieve of Eratosthenes");
        boolean[] map = new boolean[n + 1];

        seiveOfEratasthenes(n, map);

    }
    static void seiveOfEratasthenes(int n, boolean[] map){
        int i = 2; 
        while(i*i <= n){
            if(map[i] == false){
                System.out.println(i);
                map[i] = true;
                crossOutMultiples(map, i, n);
            }
            i++;
        }
        while(i <= n){
            if(map[i] == false){
                System.out.println(i);
            }
            i++;
        }
    }
    static void crossOutMultiples(boolean[] map, int i, int n){
        int val = 1;
        while(val*i <= n){
            if(map[val*i] == false){
                map[val*i] = true;
            }
            val++;
        }
    }
    static void seiveOfEratasthenesKK(int n, boolean[] primes){
        for(int i = 2; i*i <= n; i++){
            if(!primes[i]){
                for(int j = i*2; j <= n; j+=i){
                    primes[j] = true;
                }
            }
        }
        for(int i = 2; i<= n; i++){
            if(!primes[i]){
                System.out.println(i + " ");
            }
        }
    }
}
