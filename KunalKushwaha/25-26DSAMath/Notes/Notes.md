# Math for DSA

## Bitwise Operator

>Note : Bitwise operator follows associative property i.e. (a*b)*c = a*(b*c)

1. AND (&) - Both true
    > Note : Finding even odd number using AND 

2. OR (|) - Either one true

3. XOR (^) - If and only if one ture
    > Note : XOR any with 1 => compliment's the number

4. Compliment (~) - Negates the number

5. Left Shift Operator (<<) -

    ![alt text](image-4.png)

    > Note : a<<b = a*(2^b)

6. Right Shift Operator (>>) - 

    ![alt text](image-5.png)

    > Note : a>>b = a/(2^b)


## Number system

1. Decimal (Base 10) - 1 to 9

2. Binary (Base 2) - 0 & 1

    > Note : Range - [-(base)^(n-1) to (base)^(n-1) - 1] where n is number of bits coz considering base = 2 & n - 8 including 0 - (base)^(n-1) - 1 we get 128 numbers and -1 to -(base)^(n-1)128 numbers. Total unique numbers - (base)^(n) according to example 128 + 128 = 256. 

    ### Number of binary bits in an integer

    ![alt text](image-9.png)

    ![alt text](image-10.png)

    ### Negative - 
    Most Significant bit i.e. leftmost bit is set to be 1.

    Steps - 2's compliment
        
        a. Complement of number.
        b. Add 1 to it.
    ![alt text](image-6.png)

        Why?

    ![alt text](image-8.png)  

3. Octal (Base 8) - 0 to 7

4. Hexadecimal (Base 16) - 0 to 9 & A to F

### Conversion

1. Decimal to base b

    Keep dividing by base, take reminder and write in opposite.

    ![alt text](image.png)

    ![alt text](image-1.png)

2. Base b to decimal

    Multiply and add power of base with digit

    ![alt text](image-2.png)

    ![alt text](image-3.png)

## Code

### [Sum of numbers of nth row of Pascal's Triangle](../PascalsTriangle.java)

![alt text](image-11.png)

### [Power of Two or not](../PowerOfTwo.java)

![alt text](image-12.png)

### [A Power B](../APowerB.java)

![alt text](image-14.png)

### [Number of set bits](../SetBits.java)

![alt text](image-15.png)

### [XoR form 0 to n](../XOROneToN.java)

![alt text](image-16.png)

# Lec 26

## Prime Number

Check till sqrt of the number.

![alt text](image-17.png)

Prime till N - **Sieve of Eratosthenes**

![alt text](image-18.png)
*Check this also only till square root*

Time Complexity - 

![alt text](image-19.png)

## Finding Square Root of a Number

Using Binary Search, Then for precision itterate over 1 to 9 and add decimal.

Time Complexity - O(log(n))

### Newton Raphson MethodS
![alt text](image-20.png)
> *Note:* Complexity - FFT - O(log(n)*f(n)) where f(n) = cost of complexity f(n)/f'(n) with n digit precision. 


## Factor of a number

Check the divisiblity only till Square root of n as post that numbers are only interchanged.

But the answer wont be in sorted order.

## Modulo Properties
![alt text](image-21.png)
*Co-primes has only factor 1 as common factor*

![alt text](image-22.png)

## Die-hard example

Measure 4 Gallons of 3 and 5 gallons jug.

![alt text](image-23.png)

![alt text](image-24.png)

![alt text](image-25.png)

## HCF
![alt text](image-26.png)

### Joining concept of die-hard and HCF
![alt text](image-27.png)
*2 and 4 can't make 5 gallon water but 3 & 6 can make 9 also 3 & 5 can make 17*

### Euclidean's Algorithm

![alt text](image-28.png)

## LCM

![alt text](image-29.png)

![alt text](image-30.png)

![alt text](image-31.png)