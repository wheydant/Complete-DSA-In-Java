# [Video link](https://youtu.be/lmSpZ0bjCyQ)

## Problems
- Click on [*Show problem tags*](https://leetcode.com/tag/math/) and do the questions that contains tags of topics we have covered so far.

Total Questions - 28
Solved Questions - 

## Easy
1. [X][Roman to Integer.](https://leetcode.com/problems/roman-to-integer/)
1. [X][Happy Number.](https://leetcode.com/problems/happy-number/)
1. [X][Armstrong Numbers ](https://practice.geeksforgeeks.org/problems/armstrong-numbers2727/1/?category[]=Mathematical&category[]=Mathematical&page=2&query=category[]Mathematicalpage2category[]Mathematical)
1. [X][Power of Four](https://leetcode.com/problems/power-of-four/)
1. [X][Factorial](https://practice.geeksforgeeks.org/problems/factorial5739/1/?category[]=Mathematical&category[]=Mathematical&page=3&query=category[]Mathematicalpage3category[]Mathematical)
1. [X][Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)
1. [X][Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)
1. [X][Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
1. [X][Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)
1. [X][Add Binary](https://leetcode.com/problems/add-binary/)
1. [X][Power of Two](https://leetcode.com/problems/power-of-two/)

## Medium
1. [X][Integer to Roman](https://leetcode.com/problems/integer-to-roman/)
1. [X][Unique Paths](https://leetcode.com/problems/unique-paths/)

	Way to solve in mathematical formula way - https://leetcode.com/problems/unique-paths/solutions/3994523/9883-easy-dp-math-by-vanamsen-h6a1/ 

1. [X][Gray Code](https://leetcode.com/problems/gray-code/)

    https://leetcode.com/problems/gray-code/solutions/7357142/beats-9633-bit-manipulation-89-gray-code-kdt0/

	Simple yet crazy solution
    ```java
    for(i = 0; i < Math.pow(2, n); i++)
        list.add(i ^ (i >> 1));
    ```
	
1. [X][Perfect Squares](https://leetcode.com/problems/perfect-squares/)

    >**Note :** Using Lagrange’s Four-Square Theorem every natural number can be represented as the sum of four integer squares.So the answer is always between 1 to 4.

    Solution - https://leetcode.com/problems/perfect-squares/solutions/7114179/pure-math-using-java-and-bit-manipulatio-r05q/ 

1. [X][Next Greater Element III](https://leetcode.com/problems/next-greater-element-iii/)
1. [X][Angle Between Hands of a Clock](https://leetcode.com/problems/angle-between-hands-of-a-clock/)

    >**Note :** Minute is int thus double `x = min*60/30` for min = 15 will give 7 and not 7.5 but `x =(double)min*60/30` will return 7.5. Also for circular angle its not Math.min its 360 - angle

1. [X][String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)

    >**Note :** Dumb Test Cases

1. [X][The k<sup>th</sup> Factor of n](https://leetcode.com/problems/the-kth-factor-of-n/)

    >**Note :** https://leetcode.com/problems/the-kth-factor-of-n/solutions/959372/7-line-java-osqrt-n-time-o1-space-not-a-ebgxw/ efficient solution

1. [X][Queries on Number of Points Inside a Circle](https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/)

    >**Note :** `(px−cx)^2+(py−cy)^2≤r^2`


1. [X][Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

    Another Solution - https://leetcode.com/problems/product-of-array-except-self/solutions/7277577/100-optimized-from-naive-on2-prefixsuffi-6klr/ 

1. [X][Multiply Strings](https://leetcode.com/problems/multiply-strings/)
1. [X][Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/)
    ![alt text](image.png)
1. [x][Integer Break](https://leetcode.com/problems/integer-break/)

https://leetcode.com/problems/integer-break/solutions/4135679/9365-why-3s-by-vanamsen-tf31/ 

I saw many solutions were referring to factors of 2 and 3. But why these two magic numbers? Why other factors do not work?
Let's study the math behind it.

For convenience, say n is sufficiently large and can be broken into any smaller real positive numbers. We now try to calculate which real number generates the largest product.
Assume we break n into (n / x) x's, then the product will be xn/x, and we want to maximize it.

Taking its derivative gives us n * xn/x-2 * (1 - ln(x)).
The derivative is positive when 0 < x < e, and equal to 0 when x = e, then becomes negative when x > e,
which indicates that the product increases as x increases, then reaches its maximum when x = e, then starts dropping.

This reveals the fact that if n is sufficiently large and we are allowed to break n into real numbers,
the best idea is to break it into nearly all e's.
On the other hand, if n is sufficiently large and we can only break n into integers, we should choose integers that are closer to e.
The only potential candidates are 2 and 3 since 2 < e < 3, but we will generally prefer 3 to 2. Why?

Of course, one can prove it based on the formula above, but there is a more natural way shown as follows.

6 = 2 + 2 + 2 = 3 + 3. But 2 * 2 * 2 < 3 * 3.
Therefore, if there are three 2's in the decomposition, we can replace them by two 3's to gain a larger product.

All the analysis above assumes n is significantly large. When n is small (say n <= 10), it may contain flaws.
For instance, when n = 4, we have 2 * 2 > 3 * 1.
To fix it, we keep breaking n into 3's until n gets smaller than 10, then solve the problem by brute-force.


## Hard
1. [X][Permutation Sequence](https://leetcode.com/problems/permutation-sequence/)
1. [X][Basic Calculator](https://leetcode.com/problems/basic-calculator/)
1. [O][Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)

    Solution doesn't work : https://www.youtube.com/watch?v=Bb9lOXUOnFw

1. [X][Number of Digit One](https://leetcode.com/problems/number-of-digit-one/)

https://www.youtube.com/watch?v=8EXBAqRSUpk
