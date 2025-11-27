package KunalKushwaha.Assignments.Recursion;

public class PermutationSequence {
	int calK = 0;
	String kPermutation = "";
	void getAllPermutation(boolean[] vis, String currPermutation, int k){
		if(currPermutation.length() == vis.length - 1){
			calK++;
			kPermutation = currPermutation;
			return;
		}
		// System.out.println(allPermutation);
		for(int i = 1; i < vis.length; i++){
			if(!vis[i] && calK < k){
				vis[i] = true;
				getAllPermutation(vis, currPermutation + i + "", k);
				vis[i] = false;
			}
		}
	}
    public String getPermutation(int n, int k) {
		boolean[] vis = new boolean[n + 1];
		String currPermutation = "";
		getAllPermutation(vis, currPermutation, k);
		// System.out.println(allPermutation);
		return kPermutation;
    }
	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(4, 9));
	}
}
