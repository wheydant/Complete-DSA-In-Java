# Amazon
## SDE 1 - 3/12/2025

### DSA

Questions

1. https://leetcode.com/discuss/post/6225872/amazon-oa-questions-2025-sde2-by-anonymo-qrs8/ 

	Q1. LinkedList Max Pair - Reverse and find max
	
	Q2. Sort on number scale(X-axis) on the basis of weights and by the distance jump - Use 2D array to store weight position and dist.

	<details>
		<summary>Questions</summary>
		
		Question one was
		
		"Given a linked list head, reading the data from the first and last node, find the max of the pairs until the linked list is empty, the solution needs to be constant space"
		
		1->2->->1->1->8->4
		1+4 = 5
		2+8 = 10
		1+1 = 2
		max pairs are 2 and 8
		
		Solution

		Solved this one by having a fast and slow pointer once fast reaches end slow is half way in list you can reverse the second half of the list, then start adding the pairs from the two lists and keep track of the max
		
		Second question
		
		"Developers are working on a new sorting algorithm for points on the x-asis of the coordinate system. There are n points. The ith point initally has a weight of weight[i] and is located at position i on the xasis in a single operation the ith point can be moved ot the right by a distance of dist[i] given the weight and dist, find the minimum number of operations required to sort the points by their weights for example if weight = [3,6,5,2] and dist = [4,3,2,1] the answer is 5 because the number of operations is 1+2+2 = 5 and if weights = [2,4,3,1] and dist = [2,6,3,5] the ans is 4"
		
		the way I solved this was creating a vector<vector> of weight, and distance, sorted them in acending order, then looped over and kept track of a current distance and number of moves, and for each add the distance a number of times till the current distance became greater than the previous one and incrememented the number of moves every time i added a distance, then at end set current distance to the new distance.
		
		Note: I was able to answer both questions and pass ALL testcases for both and still did not make it to the onsite. So make sure you prep for the Amazon work simulation portion, these are questions like:
		
		You need to design a new message system what is the most important thing to start with, A. build prototype, B. create uml diagram, C. talk to requirments team.
		
		You are starting work on the message system what do you start with first, A. front end B. back end, C. api, D. message queue
		Good luck hope this helps someone!
	</details>

2. https://leetcode.com/discuss/post/6331313/amazon-oa-2025-sde-by-anonymous_user-eplv/

	Q1. Loadbalancing servers with server index 0 - request[i] - `(h >= numServers)h = numServers - 1;` key edge case. Crazy DP
	
	![alt text](image.png)
	![alt text](image-1.png)
	![alt text](image-2.png)
	![alt text](image-3.png)
	![alt text](image-4.png)

	Q2. Lexicographical greater Substrings of s then t. - This is how we calculate lexicographically greater

	```java
			int currLen = curr.length();
			int tLen = t.length();
			int minLen = Math.min(currLen, tLen);

			for (int k = 0; k < minLen; k++) {
				if (curr.charAt(k) != t.charAt(k)) {
					return curr.charAt(k) > t.charAt(k) ? 1 : 0;
				}
			}

			return currLen > tLen ? 1 : 0;
	```


	![alt text](image-5.png)
	![alt text](image-6.png)
	![alt text](image-7.png)
	![alt text](image-8.png)
	![alt text](image-9.png)
	![alt text](image-10.png)

	<details>
		<summary>Questions</summary>
		
		Hi Everyone,
		Today I have given the OA of AMAZON, I was not able to solve any questions completely 8/15 and 5/15.
		For the first question I was getting TLE and for the second question I was getting wrong answer.
		I have attached the questions, as well as My solution too. Could please anyone go though my solution and point me where I was doing wrong for the second question and what optimization I could have done for the first question.
		Thanks in Advance!!!

		Question 1:)


		My appraoch:)
		vector<int>findRequestTarget(int num_servers, vector<int>requests)
		{
		int n = num_servers;
		vector<int>answer;
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;
		
		for(int i=0; i<n; i++)
		{
			pq.push({0, i});
		}
		
		for(auto x: requests)
		{
			vector<int>temp;
			
			while(pq.size() && pq.top().second > x)
			{
			temp.push_back(pq.top());
			pq.pop();
			}
			
			pair<int, int>curr = pq.top();
			pq.pop();
			answer.push_back(curr.second);
			curr.first++;
			pq.push({curr.first, curr.second});
			
			for(auto y: temp)
			{
			pq.push(y);
			}
		}
		
		return answer;
		}
		Please anyone tell how we can modify the first solution

		Question 2)

		my solution:)

		long long int mod = 1e9+7;

		int find_answer(string &s, string &t, int n, int m, int i, int j, vector<vector<int>>&dp)
		{
		if(j == t.length())
		{
			return ((1L << (s.length() - i)) - 1) %mod;
		}
		
		if(i == s.length())
		return 0;
		
		if(dp[i][j] != -1)
		return dp[i][j]%mod;
		
		long count = 0;
		
		count = (count + find_answer(s, t, n, m, i+1, j, dp))%mod;
		
		if(s[i] > t[j])
		{
			count = (count + (1L << (s.length() - i - 1)))%mod;
		}
		else if(s[i] == t[j])
		{
			count = (count + find_answer(s, t, n, m, i+1, j+1))%mod;
		}
		
		return dp[i][j] = count%mod;
		
		}
		int CountSecuredStrings(string s, string t)
		{
		int n = s.length();
		int m = t.length();
		vector<vector<int>>dp(n+1, vector<int>(m+1, -1));
		return find_answer(s, t, n, m, 0, 0, dp);
		}
		Please let me know how to optimize the above two solutions, were I am doing wrong.
		Also, please let me know from which coding platform I should practise the coding questions to imrpove my coding skilss, I found this OA very tough.
	</details>

3. https://leetcode.com/discuss/post/6296159/amazon-oa-question-and-answer-by-anonymo-x6s9/

	Q1. Lexicographically larger arr string based on the state - `ans.clear();ans.addAll(curr);` weird way of assigning value of one List to another normal `ans = new ArrayList<>(curr)` doesn't work. 

	>**Note :** Recursive solution gives TLE use greedy

	<details>
		<summary>Questions</summary>
			Array Generator Service
			Your project team is collaborating with a group of software testers who have requested an array generator service to assist in testing software functionality.

			Problem Statement
			The service takes the following input parameters:

			arr: An array of n positive integers.
			state: A string of n characters, where:
			'1' indicates that the corresponding arr[i] is available for selection.
			'0' indicates that arr[i] is blocked initially.
			m: The number of operations to perform.
			Operations
			To generate an integer sequence S, perform exactly m operations as follows:

			Choose any available arr[i] (where state[i] = '1'). The same element can be chosen multiple times.
			Append the selected arr[i] to S.
			Update the state:
			Any state[i] = '0' where state[i-1] = '1' is changed to '1'.
			This means that blocked elements adjacent to available ones become available.
			Objective
			Find the lexicographically largest sequence S that can be obtained after exactly m operations.

			Example - Visit website for good representation
			Input
			arr = [10, 5, 7, 6]
			state = "0101"
			m = 2
			Operations
			Step	Available Elements	Chosen Element	Updated State
			1	{5, 6}	6	"0111"
			2	{5, 6, 7}	7	"0111"
			Output
			S = [6, 7]
			Since [6, 7] is lexicographically larger than [5, 6] or [5, 5], this is the optimal solution.

			Constraints
			1 ≤ n ≤ 10^5
			1 ≤ arr[i] ≤ 10^9
			1 ≤ m ≤ 10^5
			state is a binary string of length n.

			import java.util.*;


			public class Solution {
				public static List<Integer> generateNewArray(List<Integer> arr, String state, int m) {
					char[] cha = state.toCharArray();

					List<Integer> answer = new ArrayList<>();
					Queue<Integer> indexQueue = new LinkedList<>();
					Queue<Integer> prevIndexQueue = new LinkedList<>();
					int max = Integer.MIN_VALUE;

					for (int i = 0; i < cha.length; i++) {
						if (cha[i] == '1') {
							max = Math.max(max, arr.get(i));
							if (i < cha.length - 1 && cha[i + 1] == '0') {
								prevIndexQueue.add(i + 1);
							}
						}else {
							if(!prevIndexQueue.contains(i)) {
								indexQueue.add(i);
							}
						}
					}
					if(prevIndexQueue.isEmpty()) {
						return new ArrayList<>();
					}

					answer.add(max);

					while (!prevIndexQueue.isEmpty()) {
						int size = prevIndexQueue.size();
						for (int i = 0; i < size; i++) {
							int idx = prevIndexQueue.poll();
							if (cha[idx] == '0' && cha[idx - 1] == '1') {
								cha[idx] = '1';
								max = Math.max(max, arr.get(idx));

								if (idx < cha.length - 1 && cha[idx + 1] == '0' && !indexQueue.contains(idx + 1)) {
									indexQueue.add(idx+1);
								}
							}
						}
						answer.add(max);
					}

					while (!indexQueue.isEmpty()) {
						int idx = indexQueue.poll();
						if (idx > 0 && cha[idx] == '0' && cha[idx - 1] == '1') {
							cha[idx] = '1';
							max = Math.max(max, arr.get(idx));
							answer.add(max);
						}
					}
					int remaining = m - answer.size();
					while (remaining > 0 ) {
						answer.add(max);
						remaining--;
					}
					return answer;
				}

				public static void main(String[] args) {
				List<Integer> arr = Arrays.asList(4,9,1,2,10);
				String state = "00100";
				int m = 4;

					//   List<Integer> arr = Arrays.asList(5,4,3,6);
					// String state = "1100";
					// int m = 5;

					List<Integer> result = generateNewArray(arr, state, m);
					System.out.println(result);
				}
			}
			Worst case: O(n + m) (if m is large, at most O(2n) = O(n)).
			Best case: O(n).
			Average case: Between O(n) and O(n + m), depending on m and initial state.

			If any sugesstion please let me know. I tried cover all the test cases.
	</details>

4. https://leetcode.com/discuss/post/6438689/amazon-oa-question-sde-ii-by-anonymous_u-ujke/

	Q1. Lexicographically smallest permutation with max information gain

	![alt text](image-11.png)

5. https://leetcode.com/discuss/post/5895561/amazon-sde-1-oa-by-anonymous_user-5i2y/

	Q1. Paint to make wall beautiful - Prefix matrix [chatGPT explanation](https://chatgpt.com/share/6931cd71-84f4-8010-96a6-9e8745971604) Search prefix matrix

	![alt text](image-12.png)

6. https://leetcode.com/discuss/post/7112319/amazon-oa-sde-august-2025-by-anonymous_u-o8ee/

	Q1. Maximum number of characters that can be removed still keeping the start and end of substring same as original string - Try to fetch Every first position and try create a window from position found to next tail position. Minimize the window as much as possible

	<details>
		<summary>Questions</summary>
			I recently gave Amazon OA for SDE Position last week, below are the questions.

			Maximum number of Characters that can be removed
			This was in a form of story, but cut short the question is -
			Given a string abade denoting a machine, the type of the machine is its first character a and last character e. So in this case, the type is ae.
			In one operation, you can remove as many characters as you want from either the start or the end of the string, as long as the type doesn't change.
			For example, for the string abade, we can remove ab from start to form ade which still has type ae.
			A string a has type aa.
			Return the maximum number of characters that can be removed while keeping the type same.
	</details>

	Q2. Maximize number of package with equal cost - Calculate the entire sum and start noOfPackages from arr.length to 1 where we try to find targetSum = sum/nOfPackage and return the first hit noOfPackages as we are going in reverse order. Finding if tagetSum Can be formed using noOfPackages we sort the array and try finding first and last element - matrix [chatGPT explanation](https://chatgpt.com/share/6931cd71-84f4-8010-96a6-9e8745971604) - Search Six03122025
	<details>
		<summary>Questions</summary>	
			Find Maximum Packages with Equal Total Cost
			Again a story, but crux is -
			Given an array itemCost = [1,2,3,4,5], return the maximum number of packages that can be formed having equal total cost.
			A package has a minimum of one items.
			One item can belong to at max one package.
			For the array [1,2,3,4,5], the packages could be made like [1,4], [2,3] and [5] resulting in answer 3.
			I was able to solve both but haven't received any result email yet, any idea when can i expect a verdict?
	</details>

7. https://leetcode.com/discuss/post/4749861/amazon-oa-by-anonymous_user-1yoe/

	Q1. Make array of block good weight - *seems simple bubble sort* Not at all solution for [2, 4, 3, 1, 6] -> [1, 2, 4, 3, 6].
	Then minimal adjacent swaps required is: `swaps = i_min + (n - 1 - i_max) - (i_min > i_max ? 1 : 0)`
	
	Explanation of formula:
	- i_min swaps to bring the chosen min to index 0.
	- (n-1 - i_max) swaps to bring the chosen max to index n-1.
	- If the chosen min is to the right of the chosen max (i_min > i_max), when you move one of them across the other you'll double-count one swap, so subtract 1. (Equivalently, after you move the max to the end, the index of the min will shift left by 1, etc.)

	![alt text](image-13.png)
	![alt text](image-14.png)
	![alt text](image-15.png)
	![alt text](image-16.png)

	Q2. Distinct passwords by Reversing substrings - Each index try reversing 2, 3 .. n - 1 times.

	![alt text](image-17.png)
	![alt text](image-18.png)


8. https://leetcode.com/discuss/post/5916346/amazon-oa-by-imeth21387-xsmc/

	Q1. Minimum cost to buy all the books using cost or pairCost - Easy Recursion + DP with 3 possible options

	<details>
		<summary>Questions</summary>	
			Got this question on my OA. Could not really solve it:
			There are n books ordered sequentially as costs from 1,2...n, where the ith book has a cost of cost[i]. A customer wants to purchase all the books, and there is a scheme to minimise the cost as follows: 1. Let i = start of the array. The customer can buy the leftmost book at any moment for cost[i], this book is then removed from the array. 2. Let j = end of the array, the customer can buy the rightmost book at any moment for cost[j], this book is then removed from the array. 3. The customer can buy both the book at the start and the book at the end together for a special amount called “paircost”, then both the book at the start and the book at the end of the array are removed. Option 3 can be used up to K times. Design the function getMinimumCost which takes in an array of costs, the positive integer paircost, and K. The function should return the minimum possible cost to buy all the books in costs
	</details>

9. https://www.reddit.com/r/leetcode/comments/1htdjbf/amazon_oa_questions_w_solutions/

	Q1. Minimum health to complete the game with shield/armor - Strangely very simple calculate sum and max `return sum - Math.min(sum, shield) + 1;`

	![alt text](image-19.png)
	
	Q2. Maximize system throughput by clustering 3 host servers where throughput of a cluster is median of the 3 clusters. - Sort the host servers pick one left and 2 right.

	![alt text](image-20.png)

10. https://leetcode.com/discuss/post/1737071/amazon-oa-sde-90-min-by-anonymous_user-w7gp/

	>**Note :** Deadly question [Fuck](https://www.youtube.com/watch?v=K31VME56L3o)

	Q1. Sum of power of cache where `power[l, r] = minPower[l, r] + sumPower[l, r]` - Monotonic stack and Prefix Sum and prefix of prefix - [Almost same](https://leetcode.com/problems/sum-of-total-strength-of-wizards/) - [ChatGPT explanation - Search Ten03122025](https://chatgpt.com/share/6931cd71-84f4-8010-96a6-9e8745971604)
	![alt text](image-21.png)
	![alt text](image-22.png)
	![alt text](image-23.png)
	![alt text](image-24.png)
	![alt text](image-25.png)

11. https://leetcode.com/discuss/post/4846016/amazon-oa-by-anonymous_user-cfeu/
	
	Q1. Find maximum balanced shipments where balanced shipment is a shipment whose last parcel doesn't hold maximum weight - DP

	![alt text](image-26.png)
	![alt text](image-27.png)
	![alt text](image-28.png)
	![alt text](image-29.png)

12. https://leetcode.com/discuss/post/5011657/amazon-oa-new-grad-by-anonymous_user-fdah/

	Q1. Total_Servers connected in a circle, minimum number of time/hops to transfer data to all the servers[n] - Crazy solution just find largest gap in servers[n] (servers[n - 1] - servers[0] is the gap for anticlockwise) subtract from original total length

	![alt text](image-30.png)
	![alt text](image-31.png)
	![alt text](image-32.png)

13. https://leetcode.com/discuss/post/6333650/amazon-oa-experience-sde1-seattle-by-ano-mnny/

	Q1. Same  = 9 Q1
	<details>
		<summary>Questions</summary>	
			Amazon Prime Games is designing a game. The player needs to pass n rounds sequentially. The rules of play are as follows:
			The player loses power[i] health to complete round i.
			The player's health must be greater than 0 at all times.
			The player can choose to use armor in any one round. The armor will prevent damage of min(armor, power[i]).
			Determine the minimum starting health for a player to win the game.
	</details>

	Q2. Longest K-Consistent StockPrices can eliminate k days - Recursion with a good twist
		<details>
		<summary>Questions</summary>	
			A team of financial analysts at Amazon has designed a stock indicator to determine the consistency of Amazon's stock in delivering returns daily. More formally, the percentage return (rounded off to the nearest integer) delivered by the stock each day over the last n days is considered. This is given as an array of integers, stockPrices. The stock's k-consistency score is calculated using the following operations:

			In a single operation, omit a particular day's return from the stockPrices array to get one less element, and rejoin the parts of the array. This can be done at most k times.
			The maximum number of contiguous days during which the daily return was the same is defined as the k-consistency score for Amazon's stock. Note that the return may be positive or negative.
			As part of the team, you have been assigned to determine the k-consistency score for the stock. You are given an array stockPrices of size n representing the daily percentage return delivered by Amazon stock and a parameter k.
	</details>

14. https://www.reddit.com/r/leetcode/comments/1lz8kgv/bombed_amazon_oa/

	Q1. Maximize the power of machine where an array of power units with powers is given. Power of unit is min(power). Each machine can donate one power unit but can receive unlimited power - [God Claude](https://claude.ai/share/c31a364f-5aba-497e-b352-44a907bdd783) Recursion, Greedy etc.

		<details>
		<summary>Questions</summary>	
			Q 1) something about a list of machines where each machine has a bunch of power units.

			Like: [[1, 5], [2, 3], [1, 0]]

			The power of a specific machine is the min of all its power units, your goal is to maximize the sum of all machine powrs. You can do this by donating power units from 1 machine to another. A machine can donate 1 power unit but can receive unlimited ones.

			For this one I did a brute force approach.. and basixally ran out of time but passed like 10/15 test cases.
	</details>

	Q2. Find Longest subsequence with changes maxChangeTimes where GCD is greater than 1 - Find the prime factors of all the numbers and try making a subsequence with all the primeFactors then two factor [Chat GPT - search MaxGCDSubarray](https://chatgpt.com/share/6931cd71-84f4-8010-96a6-9e8745971604)

	<details>
		<summary>Questions</summary>	
			Q2) You have an array (1, 3, 5, 4) And a maxChangeTimes variable. You can change any number in the array to any other number maxChangeTimes, your job is to find the maximum sub array length such that the GCD of that subarray is > 1.
	</details>

15. https://www.reddit.com/r/leetcode/comments/1j96wui/amazon_oa_question/
	Q1. Chain of n servers need to be partitioned into exact k different chain where cost of each partition is server[i:j] = cost[i] + cost[j]. Return minimum and maximum cost of partition. - Easy DP + memoization. Tabulation is very messy
	![alt text](image-33.png)

16. https://leetcode.com/discuss/post/4660709/amazon-oa-recent-questions-sharing-for-t-8ze5/

	Q1. Hash function to generate seed. Where seed is number of reverse of substrings of String s and length k is lexicographically smaller than s. - Normal substring, reverse a substring `StringBuilder reverseString = new StringBuilder(s.subString(i, j)).reverse();`
	![alt text](image-34.png)
	<details>
		<summary>Questions</summary>	
			Q1: Return the number of ways to reverse any substring of length k such that the resulting string is lexicographically smaller than the original string:
			Example:

			s="amazon"
			k=3
			Consider all substrings of length k =3. These are the possible ways to perform the given operation:

			reverse the substring "ama"
			reverese the substring "maz"
			reverse the substring "azo"
			reverse the substring "zon"
			only one way is possible so the answer is 1

	</details>

	Q2. Minimum cost to purchase m items where cost of item is a[i] + (j - 1)b[i] where j is the jth type of i. - Question is kind of unclear my solution wont work according to what chatgpt feels the question wants [Chat Gpt - search Priority Queue (Min-Heap)](https://chatgpt.com/share/6931cd71-84f4-8010-96a6-9e8745971604)

	![alt text](image-35.png)
	<details>
		<summary>Questions</summary>	
			Q2: Determine the minimum possible cost to purchase exactly m items

			Example:
			given

			- a=[2,1,1] as list
			- b=[1,2,3] as list
			- m=4 as integer
			The optimal types to buy are:

			choose type i=1. This is the first purchase of this type, so j=1. This item costs a[1]+(j-1)*b[i]= 1+(1-1)*2=1
			choose type i=2. This is the first purchase of this type, so j=1. This item costs 1+(1-1)*3 = 1
			choose type i=0. This is the first purchase of this type. so j=1. This item costs 2+(1-1)*1=2
			when second item of any type is purchased, j=2. The cost of the item for each type will be:
			Type i=0, costs a[0]+(j-1)*b[0]=2+(2-1)*1=3
			Type i=1, costs 1+1*2=3
			Type i=2, costs 1+1*3=4
			Chose either the first or second type since they cost the least
			The total cost to purchase is 1+1+2+3=7

	</details>


### Leadership Principle

1. Customer Obsession - BIP Reports
2. Ownership - Consolidation of objects
3. Bias For Action - CEMLI in REACT
4. Have Backbone, Disagree and Commit - Backup script
5. Invent and Simplify - Feels difficult in current organization, Customer wanted analytical dashboard which didn't line up with product but I still pitched to my manager but was rejected
6. Dive Deep - Tried tweaking at Kernel level code, java development
7. Right a lot - Leetcode example.
8. Deliver Result - CEMLI prototype would satisfy higher management it felt right.
9. Think Big - Great products like AWS, Prime Air
10. Hire and Develop the best - I hope to raise the bar, I know I lack in a lot of areas coming from EXTC background, financial kind of not completely developer role. But my tenacity to learn and grow will definitely encourage others to a continuous learning path.
11. Frugality - Middle class family
12. Learn and Be curious - EXTC to amazon
13. Insist on Highest Standard - Commit issue value of high standards
14. Earn Trust - Be honest my project is ready to send me onsite.
15. Strive to be earth's best employer - 
16. Success and scale bring responsibility -