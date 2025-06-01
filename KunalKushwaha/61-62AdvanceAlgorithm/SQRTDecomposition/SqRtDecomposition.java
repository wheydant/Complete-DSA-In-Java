
import java.util.Arrays;

public class SqRtDecomposition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        //Build block array.
        int sqrt = (int) Math.sqrt(n);

        int block_id = -1;
        int[] blocks = new int[sqrt + 1];

        for(int i = 0; i < n; i++){
            if(i % sqrt == 0){
                block_id++;
            }
            blocks[block_id] += arr[i];
        }


        System.out.println(Arrays.toString(blocks));

        System.out.println(query(blocks, arr, 2, 7, 3));
    }
    
    public static int query(int[] blocks, int [] arr, int left, int right, int sqrt){
        int ans = 0;

        //left part
        while(left % sqrt != 0 && left < right && left != 0){
            ans += arr[left];
            left++;
        }
        //Middle
        while(left + sqrt <= right){
            ans += blocks[left/sqrt];
            left += sqrt;
        }
        //Right
        while(left <= right){
            ans += arr[left];
            left++;
        }
        return ans;
    }

    public static void update(int[] blocks, int[] arr, int i, int val, int sqrt){
        int block_id = i/sqrt;
        blocks[block_id] += (val - arr[i]);
        arr[i] = val;
    }
}
