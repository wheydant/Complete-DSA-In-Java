public class KarpRabin {
    private static final int PRIME = 101;

    private double calculateHash(String str){
        double hash = 0;
        for(int i = 0; i < str.length(); i++){
            hash = (hash + str.charAt(i)*Math.pow(PRIME, i));
        }
        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength){

        //As we have multiplied prime while hashing thus we are dividing it now we are not actually accounting to the pow still its working
        double newHash = (prevHash - oldChar)/PRIME;
        newHash = (newHash + newChar*Math.pow(PRIME, patternLength - 1));
        return newHash;
    }

    public void search(String text, String pattern){
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        //I shouldn't go out of bound
        for(int i = 0; i <= text.length() - patternLength; i++){
            if(textHash == patternHash){
                if(text.substring(i, i + patternLength).equals(pattern)){
                    System.out.println("Found at "+i);
                }
            }
            //push ahead
            if(i <= text.length() - patternLength){
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args) {
        KarpRabin algo = new KarpRabin();
        algo.search("ApoKunalRahul", "Kunal");
    }
}
