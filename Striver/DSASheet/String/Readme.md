# String

[Sheet](https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z)


## Questions

1. [X][Minimum number of bracket reversals to make an expression balanced](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)
2. [X][Count and say](https://leetcode.com/problems/count-and-say/)
3. [X][Hashing in String](https://takeuforward.org/data-structure/hashing-in-strings)
4. [X][Repeated String Match](https://leetcode.com/problems/repeated-string-match/discuss/416144/Rabin-Karp-algorithm-C%2B%2B-implementation)
	>**Note :** ord convert char value to integer
	- Rabin-Karp/ Rolling Hashing => Hash(s) = (s[0] * p^0 + s[1] * p^1 + s[2] * p^2 + ... + s[n-1] * p^(n-1)) % m [Video](https://youtu.be/qQ8vS2btsxI?si=ChmXlgl8kcaVOQhu)

		![alt text](<Screenshot_20260608_092314_Samsung capture.jpg>)

	- Z Function => [Video](https://www.youtube.com/watch?v=CpZh4eF8QBw&t=162s)

		![alt text](<Screenshot_20260608_092507_Samsung capture.jpg>)
		![alt text](<Screenshot_20260608_092556_Samsung capture.jpg>)

	- KMP => LPS - Longest Proper Prefix

		![alt text](<Screenshot_20260608_092704_Samsung capture.jpg>)
		
5. [X][Z Function](https://youtu.be/ZrWAfg1FONE?si=-JGXjT1xnSzs7QKX)
6. [X][KMP Algorithm or LPS array](https://leetcode.com/problems/implement-strstr/) [Video](https://www.youtube.com/watch?v=GTJr8OvyEVQ)
7. [X][Longest happy prefix](https://leetcode.com/problems/longest-happy-prefix/description/)
	>**Note :** Always prefix to absolute suffix no in between prefixes
8. [X][Manachers Algorithm - Count Palindromic Subsequences](https://leetcode.com/problems/palindromic-substrings/)
	>**Note :** Almost right approach found a loophole, if I would have spend more time I would have come up with this. [Video](https://www.youtube.com/watch?v=4RACzI5-du8)

	More Optimize Solution - [Video](https://www.youtube.com/watch?v=V-sEwsca1ak) Crazy and confusing

	![alt text](<AISelect_20260610_095758_Samsung Notes.jpg>)