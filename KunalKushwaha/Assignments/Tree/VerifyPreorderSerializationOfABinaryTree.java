package KunalKushwaha.Assignments.Tree;

public class VerifyPreorderSerializationOfABinaryTree {
int i = 0;
    public boolean isValidSerialization(String preorder) {
        String[] preOrderArr = preorder.split(",");
		if(preOrderArr[0].equals("#")) return false;
        boolean isValid = validPreOrder(preOrderArr);
        return isValid && i == preOrderArr.length - 1;
    }
    boolean validPreOrder(String[] preOrderArr){
        if(i >= preOrderArr.length) return false;
        if(preOrderArr[i].equals("#")) return true;
        i++;
        boolean leftCheck = validPreOrder(preOrderArr);
        i++;
        boolean rightCheck = validPreOrder(preOrderArr);

        return leftCheck && rightCheck;
    }
	public static void main(String[] args) {
		System.out.println(new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}
