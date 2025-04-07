
import java.util.Arrays;

public class Q10_HIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5, 4, 4};

        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length - i){
                return citations.length - i;
            }
        }

        return 0;
    }

    public static int hIndex1(int[] citations) {
        int papers = citations.length;
        int[] citationBuckets = new int[papers + 1];

        for (int citation : citations) {
            citationBuckets[Math.min(citation, papers)]++;
        }
        int cumulativePapers = 0;
        for (int hIndex = papers; hIndex >= 0; hIndex--) {
            cumulativePapers += citationBuckets[hIndex];
            if (cumulativePapers >= hIndex) {
                return hIndex;
            }
        }
        return 0;
    }

}
