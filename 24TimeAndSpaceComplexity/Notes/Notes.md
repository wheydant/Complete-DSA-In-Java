# Space and Time Complexity

>**Note :** Time complexity is **not** equal to time taken.

![alt text](image.png)
*Time taken is less for the new machine but relation remains the same*

Time Complexity is the function which gives the relationship about how the time will grow as the input grows.

## Parameters to consider while calculating time complexity

1. Always look for the worst case complexity
2. Always look at complexity for large/infinite data
3. Ignoring constant
    ![alt text](image-1.png)
    - Eventhough the actual time is different they are all growing linearly
    - We don't care about actual time

4. Ignore less dominating terms.

## Notations

1. Big O - Upper Bound 
    - Mathematic representation
      ![alt text](image-2.png)
      ![alt text](image-3.png)
      *N^3 solves the solution thus being the uppermost bound of the equation*

2. Big Omega - Lower bound
    ![alt text](image-4.png)

3. Theta Notation - Combines both i.e. upper bound and lower bound both are equivalent. 
    ![alt text](image-5.png)

4. Little O - Loose upper bound
    ![alt text](image-6.png)
    ![alt text](image-7.png)
    ![alt text](image-8.png)

5. Little Omega - Loose lower bound
    ![alt text](image-9.png)
    ![alt text](image-10.png)

## Space Complexity

Extra Space + Input space
![alt text](image-11.png)

## Calculating Time complexity

Q. ![alt text](image-12.png)

Ans. O(N)

![alt text](image-13.png)

## Recursive Algorithm

No function call on the same level in recursion tree will be in the stack at the same time.

Space complexity of recursion program is the longest chain of function call in the stack.

Thus Space Complexity of recursion is the height of the tree. 

![alt text](image-14.png)


## Types of recursion

1. Linear
2. Divide & Conquer

![alt text](image-15.png)

### Divide & Conquer recurrences

![alt text](image-16.png)
*Except g(n) all others are recursion calls and g(n) just specify after fetching the results what we need to do with the recursion call e.g. for binary search we just search mid thus it's constant for merge sort for merging we need (n-1) thus g(n) becomes n-1*

### How to actually solve to get complexity

1. Plug & Chug
    Take the formula and itteratively substitute in variables the whole equation, make a tree and solve for it.
    ![alt text](image-17.png)

2. Master's Theorem

    ![alt text](image-18.png)

3. Akra Bazzi

    ![alt text](image-19.png)
    *No need to scare for the integration as g(n) is time function thus lower terms can be ignored and simple integration formula will be required to solve the same*

    ![alt text](image-20.png)

    Example 1 : ![alt text](image-21.png)
    ![alt text](image-22.png)
    ![alt text](image-23.png)
    ![alt text](image-24.png)

    Example 2 : ![alt text](image-25.png)*P = 2*
    ![alt text](image-26.png)

    ### When we can't find p

    ![alt text](image-27.png)
    ![alt text](image-28.png)
    ![alt text](image-29.png)
    ![alt text](image-30.png)
    *p becomes less dominating thus ignore*

### Linear recurrences

### Homogenous Expression - No g(n)

![alt text](image-31.png)


![alt text](image-32.png)
![alt text](image-33.png)
![alt text](image-34.png)
![alt text](image-35.png)
![alt text](image-36.png)
![alt text](image-37.png)
*Formula for nth fibo number*
![alt text](image-38.png)
![alt text](image-39.png)


### Equal number of roots

![alt text](image-40.png)
![alt text](image-41.png)
![alt text](image-42.png)
![alt text](image-43.png)
![alt text](image-44.png)

### Non homogenous linear recurrsion

![alt text](image-45.png)
![alt text](image-46.png)
![alt text](image-47.png)
![alt text](image-48.png)
![alt text](image-49.png)
![alt text](image-50.png)
![alt text](image-51.png)
![alt text](image-52.png)

![alt text](image-53.png)
![alt text](image-54.png)
![alt text](image-55.png)
![alt text](image-56.png)

![alt text](image-57.png)
![alt text](image-58.png)
![alt text](image-59.png)
![alt text](image-61.png)
![alt text](image-62.png)


