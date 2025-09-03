# [ ][Video Link](https://youtu.be/zL1DPZ0Ovlo)

## Two Easy Questions + Two Medium Questions/ Day


Total Questions - 53

Completed Questions - 4

# Problems

## Easy

1. [X][Defanging an Ip address](https://leetcode.com/problems/defanging-an-ip-address/)

String Builder methods and traversal
```java
    StringBuilder defangAddress = new StringBuilder(address);
    for(int i = 0; i < defangAddress.length(); i++){
        if(defangAddress.charAt(i) == '.'){
            defangAddress.replace(i, i + 1 ,"[ ][.]");
            i = i + 3;
        }
    }
    return defangAddress.toString();
```


1. [X][Shuffle String](https://leetcode.com/problems/shuffle-string/)

Nice question assigning i to value is not what is asked instead index[i] is assigned to i

```java
    //Wrong assignment great question
    // shuffledString.setCharAt(i, s.charAt(indices[i]));
    shuffledString.setCharAt(indices[i], s.charAt(i));
```

Using char[] instead of StringBuilder runs the code faster. 

1. [X][Goal Parser Interpretation](https://leetcode.com/problems/goal-parser-interpretation/)

Used switch case which was fun

1. [X][Count Items Matching a rule](https://leetcode.com/problems/count-items-matching-a-rule/)

```java
    int index = ruleKey.equals("type")? 0 : ruleKey.equals("color")? 1 : 2;
    int matchCount = 0;
    for(List<String> item : items){
        if(item.get(index).equals(ruleValue))matchCount++;
    }
    return matchCount;
```

1. [ ][Sorting the Sentence](https://leetcode.com/problems/sorting-the-sentence/)
1. [ ][Check if two strings are equivalent](https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/)
1. [ ][To Lower Case](https://leetcode.com/problems/to-lower-case/)
1. [ ][Determine if string halves are alike](https://leetcode.com/problems/determine-if-string-halves-are-alike/)
1. [ ][Decrypt String from Alphabet to Integer Mapping](https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/)
1. [ ][Number of Strings That Appear as Substrings in Word](https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/)
1. [ ][Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)
1. [ ][Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
1. [ ][Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)
1. [ ][Implement strStr()](https://leetcode.com/problems/implement-strstr/)
1. [ ][Long Pressed Name](https://leetcode.com/problems/long-pressed-name/)
1. [ ][Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
1. [ ][Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)
1. [ ][Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
1. [ ][Maximum Repeating Substring](https://leetcode.com/problems/maximum-repeating-substring/)
1. [ ][Check if Binary String Has at Most One Segment of Ones](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)
1. [ ][Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)
1. [ ][Reverse Prefix of Word](https://leetcode.com/problems/reverse-prefix-of-word/)
1. [ ][Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
1. [ ][Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
1. [ ][Length of last word](https://leetcode.com/problems/length-of-last-word/)

## Medium

1. [ ][Jump Game VII](https://leetcode.com/problems/jump-game-vii/)
1. [ ][Split Two Strings to Make Palindrome](https://leetcode.com/problems/split-two-strings-to-make-palindrome/)
1. [ ][Number of Ways to Split a String](https://leetcode.com/problems/number-of-ways-to-split-a-string/)
1. [ ][Sentence Similarity III](https://leetcode.com/problems/sentence-similarity-iii/)
1. [ ][Repeated String Match](https://leetcode.com/problems/repeated-string-match/)
1. [ ][Next Greater Element III](https://leetcode.com/problems/next-greater-element-iii/)
1. [ ][Maximum Number of Removable Characters](https://leetcode.com/problems/maximum-number-of-removable-characters/)
1. [ ][Swap Adjacent in LR String](https://leetcode.com/problems/swap-adjacent-in-lr-string/)
1. [ ][Multiply Strings](https://leetcode.com/problems/multiply-strings/)
1. [ ][Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)
1. [ ][Minimum Length of String After Deleting Similar Ends](https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/)
1. [ ][Number of Substrings With Only 1s](https://leetcode.com/problems/number-of-substrings-with-only-1s/)
1. [ ][Count Number of Homogenous Substrings](https://leetcode.com/problems/count-number-of-homogenous-substrings/)
1. [ ][Get Equal Substrings Within Budget](https://leetcode.com/problems/get-equal-substrings-within-budget/)
1. [ ][Shifting Letters](https://leetcode.com/problems/shifting-letters/)
1. [ ][Minimum Time Difference](https://leetcode.com/problems/minimum-time-difference/)
1. [ ][Find Kth Bit in Nth Binary String](https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/)
1. [ ][Camelcase Matching](https://leetcode.com/problems/camelcase-matching/)
1. [ ][Print Words Vertically](https://leetcode.com/problems/print-words-vertically/)

## Hard

1. [ ][Valid Number](https://leetcode.com/problems/valid-number/)
1. [ ][Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)
1. [ ][Last Substring in Lexicographical Order](https://leetcode.com/problems/last-substring-in-lexicographical-order/)
1. [ ][Basic Calculator](https://leetcode.com/problems/basic-calculator/)
1. [ ][Minimum Number of Operations to Make String Sorted](https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/)
1. [ ][Check If String Is Transformable With Substring Sort Operations](https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/)
1. [ ][Orderly Queue](https://leetcode.com/problems/orderly-queue/)
1. [ ][Special Binary String](https://leetcode.com/problems/special-binary-string/)

# Additionally

1. [ ][Click "Show problem tags" and do questions that have tags for things we have learnt so far only.](https://leetcode.com/tag/string/)