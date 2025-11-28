# [Video link](https://youtu.be/fzip9Aml6og)

## Problems

Total - 28

Completed - 5

## Easy
1. [X][Add Binary](https://leetcode.com/problems/add-binary/)

    Easy and Nice Solution exist

1. [X][Single Number](https://leetcode.com/problems/single-number/)

    ^ is used for XOR in java 

1. [X][Reverse Bits](https://leetcode.com/problems/reverse-bits/)
1. [X][Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
1. [X][Counting Bits](https://leetcode.com/problems/counting-bits/)

    >**Note :** Crazy solution

    ```java
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //Find ans from i >> 1 and add 1 if its odd else add 0
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    ```
    
1. [X][Binary Watch](https://leetcode.com/problems/binary-watch/)

    Easy solution I hard coded everything
    ```java
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
    ```
1. [x][Hamming Distance](https://leetcode.com/problems/hamming-distance/)
1. [X][Number Complement](https://leetcode.com/problems/number-complement/)

    Use Or by shifting 1 to the position we are currently calculating for
    ```java
        int pos = 0;
        while(num != 0){
            int bit = num&1;
            compliment = (bit == 1)? compliment:compliment|(1<<pos);
    ```
1. [X][Set Mismatch](https://leetcode.com/problems/set-mismatch/)
    Solution using math - https://leetcode.com/problems/set-mismatch/solutions/7322862/beats-100-runtime-on-o1-complexity-by-no-acrh/
    Solution using bits - https://leetcode.com/problems/set-mismatch/solutions/4606092/beats-9908-cjavapythonjavascript-5-appro-d6ot/ 

    Complex and hard to understand - First chat in DSA - Bitwise
    
1. [X][Binary Number with Alternating Bits](https://leetcode.com/problems/binary-number-with-alternating-bits/)
1. [X][Prime Number of Set Bits in Binary Representation](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/)

    `int bits = Integer.bitCount(i);` To count number of set bits
1. [X][Binary Gap](https://leetcode.com/problems/binary-gap/)
1. [X][Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

    Simple code using bits
    ```java
        int steps = 0;
        while(num != 0){
            steps++;
            num = ((num&1) == 1)? num - 1: num>>1;
        }
        return steps;
    ```
    >**Note :** Whenever using & operator in condition always enclose it inside parenthesis `(num&1) == 1`

1. [X][Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)
1. [X][XOR Operation in an Array](https://leetcode.com/problems/xor-operation-in-an-array/)
1. [X][Count the Number of Consistent Strings](https://leetcode.com/problems/count-the-number-of-consistent-strings/)

    >**Note :** We can mark all the required chars in a single number by using bits to represent which character is requires crazy solution also it has a one liner solution.
    `return Arrays.stream(words).mapToInt(w -> w.chars().allMatch(c -> allowed.contains((char)c + "")) ? 1 : 0).sum();`

    https://leetcode.com/problems/count-the-number-of-consistent-strings/solutions/969570/javapython-3-2-codes-bit-manipulation-an-szh8/ best explanation.

1. [X][Decode XORed Array](https://leetcode.com/problems/decode-xored-array/)

    >**Note :** DeXOR is actually obtained using xor
    
1. [X][Sum of All Subset XOR Totals](https://leetcode.com/problems/sum-of-all-subset-xor-totals/)

    https://www.youtube.com/watch?v=HToBFhTa1uQ
    Fuck this question - can easily do using recursion and backtracking
    >**Note :** Crazy solution do exist refer video

1. [X][Longest Nice Substring](https://leetcode.com/problems/longest-nice-substring/)

    Solved but not at all optimized. There is bit manipulation and recursive solution. https://leetcode.com/problems/longest-nice-substring/solutions/6411970/well-go-through-my-approach-once-you-wil-vbsk/ 

## Medium
1. [X][Subsets](https://leetcode.com/problems/subsets/)

    >**Note :** Fuck always this `allSubsets.add(new ArrayList<>(currSubset));` `List<List<Integer>>` stores the reference of the List if the list value changes then all the other values changes too.

1. [X][Subsets II](https://leetcode.com/problems/subsets-ii/)

    >**Note :** Best Comparator for List<List<Integer>>
    ```java
    	Collections.sort(allSubsets, (a, b) -> {
			// 1. Empty lists come first
			if (a.isEmpty() && b.isEmpty()) return 0;
			if (a.isEmpty()) return -1;
			if (b.isEmpty()) return 1;

			// 2. Compare first element
			int cmp = Integer.compare(a.get(0), b.get(0));
			if (cmp != 0) return cmp;

			// 3. If first is equal, compare second, third, ...
			int n = Math.min(a.size(), b.size());
			for (int i = 1; i < n; i++) {
				cmp = Integer.compare(a.get(i), b.get(i));
				if (cmp != 0) return cmp;
			}

			// 4. If all equal so far, shorter list comes first
			return Integer.compare(a.size(), b.size());
		});
    ```

    https://www.youtube.com/watch?v=Vn2v6ajA7U0

    https://leetcode.com/problems/subsets-ii/solutions/7019673/unique-subsets-using-bitmasking-contains-vann/ Using bits but not that efficient we have to check the array again and again if exist.
    
1. [X][Single Number II](https://leetcode.com/problems/single-number-ii/)

    >**Note :** Counting number of set bit in each position crazy solution.

1. [O][Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

    >**Note :** Fuck all question

1. [X][Gray Code](https://leetcode.com/problems/gray-code/)

    https://leetcode.com/problems/gray-code/solutions/7357142/beats-9633-bit-manipulation-89-gray-code-kdt0/

    Simple yet crazy solution
    ```java
    for(i = 0; i < Math.pow(2, n); i++)
        list.add(i ^ (i >> 1));
    ```

1. [O][Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)

>**Note :** Sexy solution https://leetcode.com/problems/repeated-dna-sequences/solutions/53867/clean-java-solution-hashmap-bits-manipul-vmuz/ if we try to add a value in set which is already present it returns false. `v <<= 2` Pushes a variable by two bits. Please refer solution

    ```txt
    This is a great solution, and the enhancement in the comments is awesome!
    It'd be really awesome if there are some comments describing the solution though.

    So just if someone like me just walked in and might be struggling a bit with understanding what they both did,
    1. For the solution in the post
    The whole idea is to transform the DNA string to numbers (so it'll be quicker for comparison), and this is actually easy since we know for a fact that the sequence only consists of 4 letters (all upper case) 'A', 'C', 'G' and 'T'.

    If we want to map this to binary, we'd need (log 4 = 2)
    00 -> 'A'
    01 -> 'C'
    10 -> 'G'
    11 -> 'T'

    so we create an array to save these values

    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;
    Now to transform the sequences.
    We want to compare every 10 letters to the rest of the sequence, so what we'll do here is:

    Transform 10 letters
    Try to add them to a set (if the sequence already exists in the set, it will return false)
    Try to add them to a second set (If we managed to add it to the set, then this is only the second time we found that sequence, otherwise, it means that we already found it twice, and we don't need to add it to the output list)
    Add the sequence to the output list only if we couldn't add the sequence to the first set, and we successfully added it to the second set
    So, let's transform the sequence:
    First of all, we need 20 bits (10 letters * 2 bits for representing each letter)
    So we start with a variable V = 0.
    Then for each letter we shift V to the left by 2 bits and OR it with the letter representation
    so for sequence "CG" for example:
    v = 0

    v <<= 2
    v = 00

    v |= map[s.charAt(j) - 'A'];
    So map[s.charAt(j) - 'A'] = 0 = 01
    v |= 01 = 01

    Nex Character "G":
    v = 01

    v <<= 2
    v = 0100

    v |= map[s.charAt(j) - 'A'];
    So map[s.charAt(j) - 'A'] = 0 = 10
    v |= 0100 = 0110

    and so on for the 10 chars.

    Then as mentioned above, add that sequence to 2 sets, and if the sequence was:

    Added to set1 (Then don't do anything, and notice here that we're depending on the condition short circuiting, so it won't continue to execute the addition to the second set since we're using && and the first condition was true and we're using not, so it will be false) - then - we do nothing.
    Not added to set1 and added to set 2 - then - that means that we saw that exact number before, so we add it to the output list.
    Not added to set and Not added to set 2 - then - that means that we saw that number before Twice, so do nothing.
    2. For the enhancement in the comments by LIYUANZHE01
    Notice in the original solution that everytime, we go to the next character we translate the whole string.
    In other words, for the sequence "AAAAAAAAAG"
    We translate the sequence "AAAAAAAAAA"
    then the next loop we move one character to the right, and translate "AAAAAAAAAG"
    Notice here that we did the work twice to translate all the "A" letter, as we did that as part of the previous translation for the "AAAAAAAAAA"
    So the enhancement would be not to do this, so the solution would become O(N) where N is the number of characters in the sequence s.

    To do so, we simply shift the last value to the left twice, to get rid of the first character (Move it outside the 20 bits we're interested in then clear all bits after the first 20)

    So let's check the code:

    for(int i = 0; i < 10; i++){  // first value
            val = val << 2;
            val = val | map[s.charAt(i) - 'A'];
    }
    words1.add(val);
    This is exactly what we did before, but we do it separately for the very first value, and the reason we did this outside the loop is that the loop won't be doing that anymore.
    Instead, the next loop would do the enhancement we said before, so let's check the next loop:

    for(int i = 1; i < s.length() - 9; i++){ 
            val &= ~(3 << 18);
            val = val << 2;
            val = val | map[s.charAt(i+9) - 'A'];
            if(!words1.add(val) && words2.add(val)){
                res.add(s.substring(i, i + 10));
            }
    }
    Notice the first thing here is that we're not clearing val as we did before, but what we do instead is that we clear out the first 2 bits of the 20 bits as follows:

    val &= ~(3 << 18);
    So 3<<18 = 11 and put 18 zeros in front of it = 11000000000000000000
    Then invert all these bits:
    ~(3<<18) = ~(11000000000000000000) = 00111111111111111111
    When you & that with the previous value, the first 18 bits will remain as they are, and only the last 2 bits will be zeros
    then we shift that to the left to get 2 zeros to the right, and remove the last 2 zeros out of the way
    Then we or the result with the next character in the sequence.
    Then we continue with the same logic as the original algorithm.
    ```

## Hard
1. [O][Minimum Number of Flips to onvert Binary Matrix to zero matrix](https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/)
1. [ ][Minimum cost to connect two group of points](https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/)

    DP problem with bitmask

1. [X][Find XOR Sum of All Pairs Bitwise AND](https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/)

Apply DISTRIBUTIVE PROPERTY...

Lets take an example,
Given, arr1 = [a, b, c, d, e] and arr2 = [1, 2, 3]

XOR sum of all pairs

= {(a & 1) ^ (a & 2) ^ (a & 3)}  ^  {(b & 1) ^ (b & 2) ^ (b & 3)}  ^  {(c & 1) ^ (c & 2) ^ (c & 3)}  ^  {(d & 1) ^ (d & 2) ^ (d & 3)}  ^  {(e & 1) ^ (e & 2) ^ (e & 3)}

= (a & (1^2^3))  ^  (b & (1^2^3))  ^  (c & (1^2^3))  ^  (d & (1^2^3))  ^  (e & (1^2^3))

= (a^b^c^d^e)  &  (1^2^3)

# Additionally
- Click on [*Show problem tags*](https://leetcode.com/tag/bit-manipulation/) and do the questions that contains tags of topics we have covered so far.