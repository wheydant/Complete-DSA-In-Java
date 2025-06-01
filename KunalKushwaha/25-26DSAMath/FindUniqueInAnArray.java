public class FindUniqueInAnArray {
    public static void main(String[] args) {
        int[] numbersTwice = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 0}; // Example array

        int[] numbersThrice = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7};
        int n = 3;

        System.out.println("The unique number is: " + findUniqueInDoubleRep(numbersTwice));

        System.out.println("The unique number "+ n + " is: " + uniNumInNrep(numbersThrice, n));
    }

    public static int findUniqueInDoubleRep(int[] numbers){
        int missingNumber = 0;
        for(int element : numbers){
            missingNumber ^= element;
        }
        return missingNumber;
    }

    //Thought process - Number appearing three times then bit position will also appear three times for all the possible bits in that position wherever it's not a multiple of 3 those bits are set decoding them will give the answer

    public static int uniNumInNrep(int[] numbers, int n){
        int[] bitCount = new int[32];
        for(int element : numbers){
            for(int i = 0; i < 32; i++){
                if((element & (1<<i)) != 0){
                    bitCount[i]++;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 32; i++){
            if(bitCount[i] % n != 0){
                result |= (1<<i);
            }
        }

        return result;
    }
}
