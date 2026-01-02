package KunalKushwaha.Assignments.StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteriodCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> survivingAsteroids = new ArrayList<>();
		for (int i = 0; i < asteroids.length; i++) {
			if (asteroids[i] > 0)
				stack.push(asteroids[i]);
			else {
				if (stack.isEmpty()) {
					survivingAsteroids.add(asteroids[i]);
					continue;
				}
				int currAsteroid = stack.peek();
				if (currAsteroid > asteroids[i] * -1) {
					continue;
				} else if (currAsteroid == asteroids[i] * -1) {
					stack.pop();
					continue;
				}
				// int stackAsteroid = stack.peek();
				while (!stack.isEmpty() && stack.peek() <= asteroids[i] * -1) {
					currAsteroid = stack.pop();
					if (currAsteroid == -1 * asteroids[i])
						break;
					if (stack.isEmpty()) {
						survivingAsteroids.add(asteroids[i]);
					}
				}
			}
		}

		int i = survivingAsteroids.size();
		while (!stack.isEmpty())
			survivingAsteroids.add(i, stack.pop());

		return survivingAsteroids.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] asteroidCollisionOptimized(int[] asteroids) {
		Stack<Integer> st = new Stack<>();

		for (int a : asteroids) {
			if (a > 0) {
				st.push(a);
			} else {
				while (!st.isEmpty() && st.peek() > 0 && st.peek() < -a) {
					st.pop();
				}
				if (st.isEmpty() || st.peek() < 0) {
					st.push(a);
				} else if (st.peek() == -a) {
					st.pop();
				}
			}
		}

		int[] res = new int[st.size()];
		for (int i = st.size() - 1; i >= 0; i--) {
			res[i] = st.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(new
		// AsteriodCollision().asteroidCollision(new int[] { 8, -8 })));
		System.out.println(Arrays.toString(new AsteriodCollision().asteroidCollision(new int[] { -2, 2, 1, -2 })));
		// System.out.println(Arrays.toString(new
		// AsteriodCollision().asteroidCollision(new int[] {-2,1,1,-1})));
		// System.out.println(Arrays.toString(new
		// AsteriodCollision().asteroidCollision(new int[] {1,2,1,-2})));
	}
}
