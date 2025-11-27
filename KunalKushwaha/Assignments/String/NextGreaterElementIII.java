package KunalKushwaha.Assignments.String;

public class NextGreaterElementIII {
    public int nextGreaterElement(int num) {
        String str = String.valueOf(num); // Convert integer to string
        int[] result = new int[str.length()];

        // Convert each character back to an integer and store it in the array
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - '0'; // Convert char to int
        }

        //now result array have the integer num in array form.
        //now do same thing we do in next permutation question.
        int i=result.length-2;
        while(i>=0 && result[i] >= result[i+1])
        {
            //Find the value which can be flipped 
            i--;
        }

        if(i>=0)
        {
            //Find the smallest digit in the RHS
            int j = result.length-1;
            while(j>=0 && result[j] <= result[i])
            {
                j--;
            }
            //Swap them
            swap(result,i,j);
        }

        //Reverse the digits to get the next smallest
        reverse(result,i+1,result.length-1);

        int digit = 0;
        for(int a=0;a<result.length;a++)
        {
            digit = digit*10 + result[a];
        }

        //now the next permutation digit is formed.
        //now just check if it is greater or smaller.
        if(digit > num)
        {
            return digit;
        }
        return -1;
    }

    public void swap(int[] nums,int a,int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int []nums,int s,int e)
    {
        while(s<e)
        {
            swap(nums,s,e);
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        // System.out.println(new NextGreaterElementIII().nextGreaterElement(12));//21

        System.out.println(new NextGreaterElementIII().nextGreaterElement(21));//-1

        // 321, 341, 345 => 
    }
}
